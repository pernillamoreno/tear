package com.awsomeRoutePlanner.indivitualTransportation.controller;

import com.awsomeRoutePlanner.indivitualTransportation.model.BaseRouting;
import com.awsomeRoutePlanner.indivitualTransportation.service.BicycleWalkRoutingService;
import com.awsomeRoutePlanner.indivitualTransportation.service.DriveRoutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndividualTransportController {

    @Autowired
    private BicycleWalkRoutingService bicycleWalkRoutingService;

    @Autowired
    private DriveRoutingService driveRoutingService;

    @GetMapping("/route/{mode}")
    public ResponseEntity<BaseRouting> showBicycleAndWalkRoute(@PathVariable String mode,
                                                               @RequestParam String origin,
                                                               @RequestParam String destination) {
        if ("drive".equals(mode)){
            return ResponseEntity.ok(driveRoutingService.getRoute( origin, destination));
        } else {
            return ResponseEntity.ok(bicycleWalkRoutingService.getRoute(mode, origin, destination));
        }
    }


}
