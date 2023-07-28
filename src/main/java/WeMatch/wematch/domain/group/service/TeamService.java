package WeMatch.wematch.domain.group.service;

import WeMatch.wematch.domain.group.dto.GetTeamResponseDto;
import WeMatch.wematch.domain.group.dto.SleepTimeDto;
import WeMatch.wematch.domain.group.dto.TeamEventsResponseDto;
import WeMatch.wematch.domain.group.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public List<TeamEventsResponseDto> getEvents(Long groupId) {
        //보류 -> 그냥 바로 dto로 받아올 수 있을 것 같음 : List<dto>
        //대신 mybatis resultType 다시 한 번 검토해야 함
        /*Map<String, String> events = new HashMap<>();
        Long[] memberList = groupRepository.getMembers(groupId);
        for(Long memberId:memberList) {
            events=groupRepository.getEvent(memberId);
        }*/

        List<TeamEventsResponseDto> results = teamRepository.getEvent(groupId);
        return results;
    }

    public List<TeamEventsResponseDto> getResult(List<TeamEventsResponseDto> events,int weekNumber,int year) {
        Iterator<TeamEventsResponseDto> iterator = events.iterator();
        while(iterator.hasNext()) {
            TeamEventsResponseDto event = iterator.next();
            if(event.getEventStartAt().toLocalDate().get(WeekFields.ISO.weekOfYear())!=weekNumber
                    || event.getEventStartAt().getYear()!=year) {
                iterator.remove();
            }
        }
        return events;
    }

    public GetTeamResponseDto getTeamInfo(Long groupId) {
        return teamRepository.getTeamInfo(groupId);
    }

    public void updateSleep(Long groupId, SleepTimeDto sleepTimeDto) {
        teamRepository.updateSleep(groupId, sleepTimeDto);
    }

    public SleepTimeDto getSleep(Long groupId) {
        return teamRepository.getSleep(groupId);
    }
}
