package com.awsomeRoutePlanner.indivitualTransportation.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class BicycleWalkRouting extends BaseRouting {

    private JsonNode weather;

}
