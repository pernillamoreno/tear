package com.example.municipaltransport.service;

import com.example.municipaltransport.model.Route;
import com.example.municipaltransport.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;

import java.util.List;
@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    public List<Route> getAll() {
        return routeRepository.findAll();

    }

    public Route getRouteById(long id) {
        return routeRepository.findById(id).orElse(null);
    }

    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }



    public Route updateRoute(long id, Route route) {
        return routeRepository.save(route);
    }


    public List<Route> findByStartLocatin(String startLocation) {
        return routeRepository.findRouteByStartLocation(startLocation);
    }
    public Route save(Route route) {
        return routeRepository.save(route);
    }

    public void deleteRoute(long id) {
        routeRepository.deleteById(id);
    }
}




