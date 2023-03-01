package com.example.awesomerouteplaner_municipaltransport.exeptions;

public class RouteExeption extends RuntimeException  {

    public RouteExeption (Long id){
        super("This Route was not find: " + id);
    }
}
