package com.example.publictransport.exeption;


public class RouteExeption extends RuntimeException  {

    public RouteExeption (Long id){
        super("This Route was not find: " + id);
    }
}
