package com.example.microsergrouptransport.Service;

import com.example.microsergrouptransport.Repository.GroupRepository;
import com.example.microsergrouptransport.Repository.WalkRepository;
import com.example.microsergrouptransport.model.Group;
import com.example.microsergrouptransport.model.Walk;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j

public class WalkService {
    private WalkRepository walkRepository;

    public Walk createWalk(Walk walk) {
        return walkRepository.save(walk);
    }


    public void deleteWalk(Long walkId) {
        walkRepository.removeById(walkId);
    }
}
