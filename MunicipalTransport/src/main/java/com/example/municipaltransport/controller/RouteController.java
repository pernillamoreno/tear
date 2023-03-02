package com.example.municipaltransport.controller;

import com.example.municipaltransport.model.Route;
import com.example.municipaltransport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/routes/*")
public class RouteController {

    @Autowired
    private RouteService routeService;

    private List<Route> routeList;

    @GetMapping
    public ResponseEntity<List<Route>> getRoutes() {
        List<Route> routeList = routeService.getAll();
        return ResponseEntity.ok(routeList);
    }

    @PostMapping
    public ResponseEntity<List<Route>> createRoute(@RequestBody Route route) {
        routeService.save(route);
        return ResponseEntity.status(201).body(routeList);
    }

    @GetMapping("/route/{id}")
    public List<Route> getRouteByStartLocation(@PathVariable String startLocation) {
        List<Route> routes = routeService.findByStartLocatin(startLocation);
        return routes;
    }
   /* @GetMapping("traffic/")
    public ResponseEntity<TrafficDetails> getGeoCooding(RestTemplate restTemplate) {
        StringBuilder builder = new StringBuilder("https://api.resrobot.se/v2.1/trip?");
        builder
                .append("format=").append("json")
                .append("&originId=").append("740000001")
                .append("&destId=").append("740000003")
                .append("&accessId=").append("<API_KEY_HERE>");

        ResponseEntity<TrafficDetails> traffic = restTemplate
                .getForEntity(builder.toString(), TrafficDetails.class);


        return ResponseEntity.ok(traffic.getBody());
    }*/


    @PutMapping("/update/{id}")
    public Route updateRoute(@PathVariable("id") long id, @RequestBody Route route) {
        return routeService.updateRoute(id, route);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoute(@PathVariable("id") long id) {
        routeService.deleteRoute(id);
    }

}