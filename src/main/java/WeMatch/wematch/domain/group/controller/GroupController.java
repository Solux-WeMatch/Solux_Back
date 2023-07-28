package WeMatch.wematch.domain.group.controller;

import WeMatch.wematch.domain.group.entity.Group;
import WeMatch.wematch.domain.group.repository.GroupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/group")
public class GroupController {
    private GroupRepository groupRepository = GroupRepository.getInstance();

    // 그룹 생성
    @PostMapping("/create")
    public Group createGroup(@RequestBody Group group) {
        return groupRepository.save(group);
    }


}
