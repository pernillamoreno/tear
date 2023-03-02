package com.example.municipaltransport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter@Setter
@Entity
public class Route {


    @GeneratedValue
    @Id
    private Long id;


    private String startLocation;


    private String endLocation;


    private String travelTime;


    private int changes;


    private boolean isFavoriteTravelRoute;
    //@Column(nullable = false)
    //private LocalDateTime startTime;

}
