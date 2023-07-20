package WeMatch.wematch.mapper;

import WeMatch.wematch.domain.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    String test(String name);

    //Email로 회원 중복여부 판단
    boolean ifExists(String email);

    //회원가입 : Member table에 저장
    void save(Member member);

    // email로 Member 찿기
    Member findByEmail(String email);

}
