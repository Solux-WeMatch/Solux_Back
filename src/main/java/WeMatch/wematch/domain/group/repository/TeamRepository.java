package WeMatch.wematch.domain.group.repository;

import WeMatch.wematch.domain.group.dto.GetTeamResponseDto;
import WeMatch.wematch.domain.group.dto.TeamEventsResponseDto;
import WeMatch.wematch.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamRepository {
    private final Mapper teamDAO;

    public List<TeamEventsResponseDto> getEvent(Long groupId) {
        return teamDAO.getEvent(groupId);
    }

    public GetTeamResponseDto getTeamInfo(Long groupId) {
        List<String> memberList= teamDAO.getTeamMembers(groupId);
        String teamName = teamDAO.getTeamName(groupId);
        return GetTeamResponseDto.builder()
                .groupName(teamName)
                .members(memberList)
                .build();
    }
}
