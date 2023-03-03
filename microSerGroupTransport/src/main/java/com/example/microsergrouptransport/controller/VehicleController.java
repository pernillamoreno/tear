package com.example.microsergrouptransport.controller;

import com.example.microsergrouptransport.Service.VehicleService;
import com.example.microsergrouptransport.model.Group;
import com.example.microsergrouptransport.model.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/groupTransport")
@AllArgsConstructor

public class VehicleController {
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        if (vehicles == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.OK).body(vehicles);
    }


        @PutMapping("vehicle")
        public ResponseEntity<List<Vehicle>> addVehicle(@RequestBody Vehicle vehicle) {
            List<Vehicle> vehicles = new ArrayList<>();
            vehicles.add(new Vehicle());
            vehicleService.addVehicle(vehicle);
            return new ResponseEntity<>(vehicles, HttpStatus.CREATED);
        }

//        @GetMapping("{vehicleId}")
//    public ResponseEntity <List<Vehicle>> isAvailable(@PathVariable("vehicleId") Long vehicleId){
//        List<Vehicle> isAvailableVehicle = vehicleService.findAvailable(vehicleId);
//        return ResponseEntity.ok(isAvailableVehicle);
//    }

//    @GetMapping("/isAvailable")
//    public ResponseEntity<List<Vehicle>> getAllAvailableVehicles() {
//        List<Vehicle> availableVehicles = new ArrayList<>();
//                vehicleService.getAllAvailableVehicles();
//        if (availableVehicles == null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return ResponseEntity.status(HttpStatus.OK).body(availableVehicles);
//    }

//    @GetMapping("/isAvailable")
//    public ResponseEntity<List<Vehicle>> getAllAvailableVehicles(@PathVariable("isAvailable") Boolean isAvailable) {
//        List<Vehicle> availableVehicles = vehicleService.getAllAvailableVehicles(isAvailable);
//        if (availableVehicles == null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return ResponseEntity.status(HttpStatus.OK).body(availableVehicles);
//    }

//    @GetMapping("{vehicleId}")
//    public ResponseEntity <List<Vehicle>> isBusy(@PathVariable("vehicleId") Long vehicleId){
//        List<Vehicle> isBusyVehicle = vehicleService.findBusy(vehicleId);
//        return ResponseEntity.ok(isBusyVehicle);


//    @GetMapping("/isBusy")
//    public ResponseEntity<List<Vehicle>> getAllBusyVehicles(@PathVariable("isBusy") Boolean isBusy) {
//        List<Vehicle> busyVehicles = vehicleService.getAllBusyVehicles(isBusy);
//        if (busyVehicles == null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return ResponseEntity.status(HttpStatus.OK).body(busyVehicles);
//    }

//    @GetMapping("{vehicleId}")
//    public ResponseEntity<Boolean> isAvailable(@PathVariable("vehicleId") Long vehicleId){
//        boolean isAvailableVehicle = vehicleService.isAvailableVehicle(vehicleId);
//        return ResponseEntity.ok(isAvailableVehicle);
//    }

//    @GetMapping("/vehicles/{vehicleId}")
//    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("vehicleId") Long vehicleId){
//        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
//        return ResponseEntity.ok(vehicle);
//    }



    @DeleteMapping("/vehicles/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
