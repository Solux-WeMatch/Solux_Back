package WeMatch.wematch.domain.member.controller;

import WeMatch.wematch.mapper.MemberMapper;
import WeMatch.wematch.domain.member.dto.JwtRequestDto;
import WeMatch.wematch.domain.member.dto.MemberSignUpRequestDto;
import WeMatch.wematch.domain.member.service.AuthService;
import WeMatch.wematch.domain.member.service.MemberService;
import WeMatch.wematch.response.Response;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import static WeMatch.wematch.response.ResponseMessage.*;
import static WeMatch.wematch.response.Response.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final MemberService memberService;

    @PostMapping("/testMapping")
    public String testMapping(String name) {
        return authService.test(name);
    }

    //회원가입
    @PostMapping("/sign-up")
    public Response signUp(@RequestBody MemberSignUpRequestDto request) {
        authService.singUp(request);
        return success(SUCCESS_SIGN_UP);
    }

    //로그인
    @PostMapping("/login")
    public Response login(@RequestBody JwtRequestDto request) {
        return success(SUCCESS_SIGN_IN,authService.login(request));
    }
}
