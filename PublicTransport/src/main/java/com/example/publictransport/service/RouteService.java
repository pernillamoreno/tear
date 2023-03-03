package com.example.publictransport.service;

import com.example.publictransport.model.Route;
import com.example.publictransport.repository.RouteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;

import java.util.List;
@Service
@Log4j2
public class RouteService {


    @Autowired
    RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        log.debug("All courses is being fetched");
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

    public Route addRoute(Route route) { {return routeRepository.save(route);
    }
    }
}
