/*package com.example.publictransport.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class TrafficDetails {

    @JsonAlias("Trip")
    private TripDetails[] trip;

    @Data
    public static class TripDetails {

        @JsonAlias("ServiceDays")
        private ServiceDaysDetails[] serviceDays;


        @Data
        public static class ServiceDaysDetails {
            private String planningPeriodBegin;
            private String planningPeriodEnd;
        }
    }
}*/
