package com.example.microsergrouptransport.Repository;

import com.example.microsergrouptransport.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAll();

    Vehicle save(Vehicle vehicle);

//    List<Vehicle> findByActiveTrue(Long vehicleId);

//    List<Vehicle> findAll();

//    List<Vehicle> findAll(Boolean isAvailable);


//    List<Vehicle> findByActiveFalse(Long vehicleId);

//    List<Vehicle> findAll(Boolean isBusy);

//    boolean save(Long vehicleId);

//    Vehicle findById(Long vehicleId);
    void removeById(Long vehicleId);
}
