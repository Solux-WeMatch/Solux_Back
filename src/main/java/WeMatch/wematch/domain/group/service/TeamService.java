package WeMatch.wematch.domain.group.service;

import WeMatch.wematch.domain.group.dto.TeamEventsResponseDto;
import WeMatch.wematch.domain.group.repository.GroupRepository;
import WeMatch.wematch.domain.group.repository.TeamRepository;
import com.google.gson.Gson;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public String getEvents(Long groupId) {
        //보류 -> 그냥 바로 dto로 받아올 수 있을 것 같음 : List<dto>
        //대신 mybatis resultType 다시 한 번 검토해야 함
        /*Map<String, String> events = new HashMap<>();
        Long[] memberList = groupRepository.getMembers(groupId);
        for(Long memberId:memberList) {
            events=groupRepository.getEvent(memberId);
        }*/

        List<TeamEventsResponseDto> results = teamRepository.getEvent(groupId);
        String resultJson = new Gson().toJson(results);
        return resultJson;
    }
}
