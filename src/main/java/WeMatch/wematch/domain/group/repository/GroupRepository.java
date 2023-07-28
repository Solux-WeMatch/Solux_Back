package WeMatch.wematch.domain.group.repository;

import WeMatch.wematch.domain.group.dto.TeamEventsResponseDto;
import WeMatch.wematch.domain.group.entity.Group;
import WeMatch.wematch.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class GroupRepository {
    private static Map<Long, Group> groupstore = new HashMap<>();
    private static long sequence = 0L;

    private static final GroupRepository instance = new GroupRepository();

    public static GroupRepository getInstance() {
        return instance;
    }

    private GroupRepository(){

    }

    public Group save(Group group){
        group.setGroupId(++sequence);
        groupstore.put(group.getGroupId(), group);
        return group;
    }

    public Group delete(Group group){
        groupstore.remove(group.getGroupId());
        return group;
    }


    public Group findById(Long groupId){
        return groupstore.get(groupId);
    }

    public List<Group> findAll() {
        return new ArrayList<>(groupstore.values());
    }

    public void clearGroupStore(){
        groupstore.clear();
    }
}
