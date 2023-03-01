package com.example.awesomerouteplaner_municipaltransport.repository;

import com.example.awesomerouteplaner_municipaltransport.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
    public interface RouteRepository extends JpaRepository<Route, Long> {

   
    List<Route> findRouteByStartLocation(String startLocation);
    List<Route> findRouteByendLocation(String endLocation);


}
