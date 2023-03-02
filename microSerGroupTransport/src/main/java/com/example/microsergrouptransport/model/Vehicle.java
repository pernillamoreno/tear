package com.example.microsergrouptransport.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicleId")
    private Long vehicleId;

    @Column(name="vehicleType")
    private String vehicleType;

    @Column(name="vehicleOwner")
    private String vehicleOwner;

    @Column(name="vehicleLocation")
    private String vehicleLocation;

    @Column(name="time")
    private String time;

    @Column(name="isAvailable")
    private boolean isAvailable;

    @Column(name="isBusy")
    private boolean isBusy;

}
