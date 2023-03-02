package com.example.microsergrouptransport.controller;

import com.example.microsergrouptransport.Service.WalkService;
import com.example.microsergrouptransport.model.Group;
import com.example.microsergrouptransport.model.Walk;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/groupTransport")
@AllArgsConstructor

public class WalkController {
    private WalkService walkService;

    @PostMapping("walks/walk")
    public ResponseEntity<Walk> createWalk(@RequestBody Walk walk){
        Walk createdWalk = walkService.createWalk(walk);
        return new ResponseEntity<>(createdWalk, HttpStatus.CREATED);
    }


    @DeleteMapping("/walks/{walkId}")
    public ResponseEntity<Void> deleteWalk(@PathVariable Long walkId) {
        walkService.deleteWalk(walkId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


}
