package com.example.microsergrouptransport.controller;

import com.example.microsergrouptransport.Service.GroupService;
import com.example.microsergrouptransport.model.Group;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/groupTransport")
@AllArgsConstructor

public class GroupController {
    private GroupService groupService;

    @PostMapping("groups/group")
    public ResponseEntity<Group> createGroup(@RequestBody Group group){
        Group createdGroup = groupService.createGroup(group);
        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        if (groups == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.OK).body(groups);
    }

    @GetMapping("/groups/{groupName}")
    public ResponseEntity<Group> getGroupByName(@PathVariable("groupName") String groupName){
        Group group = groupService.getGroupByName(groupName);
        return ResponseEntity.ok(group);
    }
}
