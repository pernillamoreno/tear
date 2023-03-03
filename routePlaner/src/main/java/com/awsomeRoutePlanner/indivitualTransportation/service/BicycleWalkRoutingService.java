package com.awsomeRoutePlanner.indivitualTransportation.service;

import com.awsomeRoutePlanner.indivitualTransportation.client.RoutingClient;
import com.awsomeRoutePlanner.indivitualTransportation.client.WeatherClient;
import com.awsomeRoutePlanner.indivitualTransportation.model.BicycleWalkRouting;
import com.awsomeRoutePlanner.indivitualTransportation.model.LatLon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleWalkRoutingService {

    @Autowired
    private RoutingClient routingClient;
    @Autowired
    private WeatherClient weatherClient;

    /**
     * @param navigateMode can be one of "walk" "bicycle" "drive"
     */
    public BicycleWalkRouting getRoute(String navigateMode, String originAddress, String destinationAddress){

        BicycleWalkRouting bicycleWalkRouting = new BicycleWalkRouting();

        // get latlon by street address
        LatLon origin = routingClient.getLatLon(originAddress);
        LatLon destination = routingClient.getLatLon(destinationAddress);
        if (origin == null || destination == null){
            bicycleWalkRouting.setErrors(List.of("Could not fetch address details."));
            return bicycleWalkRouting;
        }

        // get routing info
        String route = routingClient.getRoute(origin, destination, navigateMode);
        if (route == null){
            bicycleWalkRouting.addError("Could not fetch routing information.");
        } else {
            JsonNode routeNode = extractRouteInfo(route);
            bicycleWalkRouting.setRoute(routeNode);
        }

        // get weather info
        String weatherResponse = weatherClient.getWeatherInfo(destination);
        if (weatherResponse == null){
            bicycleWalkRouting.addError("Could not fetch weather information.");
        } else {
            JsonNode weatherNode = extractWeatherInfo(weatherResponse);
            bicycleWalkRouting.setWeather(weatherNode);
        }

        // prepare service response
        if (bicycleWalkRouting.getRoute() == null || bicycleWalkRouting.getWeather() == null){
            bicycleWalkRouting.setErrors(List.of("Failed to process third party API response."));
        }

        return bicycleWalkRouting;
    }

    private static JsonNode extractRouteInfo(String route) {
        try {
            JsonNode node = new ObjectMapper().readTree(route);
            node = node.get("features").get(0).get("properties").get("legs").get(0);
            return node;
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    private static JsonNode extractWeatherInfo(String weatherResponse) {
        try {
            JsonNode node = new ObjectMapper().readTree(weatherResponse);
            return node;
        } catch (JsonProcessingException e) {
            return null;
        }
    }


}
