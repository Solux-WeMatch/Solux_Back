package WeMatch.wematch.mapper;

import WeMatch.wematch.domain.group.dto.TeamEventsResponseDto;
import WeMatch.wematch.domain.group.repository.TeamRepository;
import WeMatch.wematch.domain.member.entity.Member;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {

    String test(String name);

    //Email로 회원 중복여부 판단
    boolean ifExists(String email);

    //회원가입 : Member table에 저장
    void save(Member member);

    // email로 Member 찿기
    Member findByEmail(String email);

    //groupId -> memberId -> event : TeamEventResponseDto
    List<TeamEventsResponseDto> getEvent(Long groupId);

}
