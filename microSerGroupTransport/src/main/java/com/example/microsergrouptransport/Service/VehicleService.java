package com.example.microsergrouptransport.Service;

import com.example.microsergrouptransport.Repository.VehicleRepository;
import com.example.microsergrouptransport.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Builder
public class VehicleService {
    private VehicleRepository vehicleRepository;

    private boolean isAvailable;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }



    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

//    public List<Vehicle> findAvailable(Long vehicleId) {
//        return vehicleRepository.findByActiveTrue(vehicleId);
//    }
//
//    public List<Vehicle> getAllAvailableVehicles() {
//            if(!isAvailable) {
//                return null;
//            }
//        return vehicleRepository.findAll();
//    }

//    public List<Vehicle> getAllAvailableVehicles(Boolean isAvailable) {
//        return vehicleRepository.findAll(isAvailable);
//    }

//    public List<Vehicle> findBusy(Long vehicleId) {
//        return vehicleRepository.findByActiveFalse(vehicleId);
//    }

//    public List<Vehicle> getAllBusyVehicles(Boolean isBusy) {
//        return vehicleRepository.findAll(isBusy);
//    }

//    public boolean isAvailableVehicle(Long vehicleId) {
//        vehicleRepository.save(Vehicle.builder().vehicleId(vehicleId).isAvailable(false).build());
//        return false;
//        }

//    public Vehicle getVehicleById(Long vehicleId) {
//        return vehicleRepository.findById(vehicleId);
//    }

    public void deleteVehicle(Long vehicleId) {
        vehicleRepository.removeById(vehicleId);
    }
}
