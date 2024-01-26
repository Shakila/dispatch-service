package org.musala.org.musala.dispactservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.musala.org.musala.dispactservice.dtos.DroneDto;
import org.musala.org.musala.dispactservice.models.Drone;
import org.musala.org.musala.dispactservice.services.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/drones")
@RequiredArgsConstructor
@Slf4j
public class DroneController {
    @Autowired
    private final DroneService droneService;

    @PostMapping
    public ResponseEntity<Drone> registerDrone(@RequestBody @Valid DroneDto droneDto) {
        return ResponseEntity.ok(droneService.registerDrone(droneDto));
    }

    @GetMapping
    public ResponseEntity<List<Drone>> getAllDrones() {
        return ResponseEntity.ok().body(droneService.getAllDrones());
    }

    @PutMapping
    public ResponseEntity<String> loadDroneWithMedication(@RequestParam String serialNumber,
                                                          @RequestParam List<String> medicationCodes) {
        return ResponseEntity.ok().body(droneService.loadDroneWithMedications(serialNumber, medicationCodes));
    }
}
