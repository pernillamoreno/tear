package com.example.microsergrouptransport.Service;

import com.example.microsergrouptransport.Repository.GroupRepository;
import com.example.microsergrouptransport.model.Group;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GroupService {

    private GroupRepository groupRepository;


    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupByName(String groupName) {
        return groupRepository.findByName(groupName);
    }
}
