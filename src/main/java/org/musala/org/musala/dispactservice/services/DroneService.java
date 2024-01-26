package org.musala.org.musala.dispactservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.musala.org.musala.dispactservice.dtos.DroneDto;
import org.musala.org.musala.dispactservice.enums.State;
import org.musala.org.musala.dispactservice.exceptions.ClientException;
import org.musala.org.musala.dispactservice.exceptions.ExceptionMessageCreator;
import org.musala.org.musala.dispactservice.models.AvailableMedication;
import org.musala.org.musala.dispactservice.models.Drone;
import org.musala.org.musala.dispactservice.models.Medication;
import org.musala.org.musala.dispactservice.repositories.AvailableMedicationRepository;
import org.musala.org.musala.dispactservice.repositories.DroneRepository;
import org.musala.org.musala.dispactservice.repositories.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.musala.org.musala.dispactservice.utils.Constants.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class DroneService {
    @Autowired
    private final DroneRepository droneRepo;
    @Autowired
    private final MedicationRepository medicationRepo;
    @Autowired
    private final AvailableMedicationRepository availableMedicationRepo;
    private final ExceptionMessageCreator messageCreator;

    public Drone registerDrone(DroneDto droneDto) {
        if (droneRepo.count() == DRONE_FLEET_LIMIT)
            ClientException.of(messageCreator.createMessage(DRONE_FLEET_SIZE_EXCEEDED));
        Drone drone = Drone.builder()
                .serialNumber(droneDto.getSerialNumber())
                .model(droneDto.getModel())
                .weight(0)
                .battery(droneDto.getBattery())
                .state(State.IDLE)
                .build();
        return droneRepo.saveAndFlush(drone);
    }

    public List<Drone> getAllDrones() {
        return droneRepo.findAll();
    }

    public  String  loadDroneWithMedications(String serialNumber, List<String> medicationCodes) {
        Drone d = droneRepo.findById(serialNumber).orElseThrow(() -> ClientException.of(messageCreator.createMessage(DRONE_SERIAL_NUMBER_NOT_FOUND)));
        medicationCodes.forEach(mC -> {
            Medication m = medicationRepo.findById(mC).orElseThrow(() -> ClientException.of(messageCreator.createMessage(MEDICATION_CODE_NOT_FOUND)));
            int newWeight = d.getWeight() + m.getWeight();
            if (newWeight > WEIGHT_LIMIT)
                ClientException.of(messageCreator.createMessage(MEDICATION_OVERLOAD));

            AvailableMedication aM = AvailableMedication.builder()
                    .drone(d.getSerialNumber())
                    .medication_code(mC)
                    .build();
            availableMedicationRepo.saveAndFlush(aM);

            if (newWeight < WEIGHT_LIMIT) {
                d.setWeight(newWeight);
                d.setState(State.LOADING);
            }
            if (newWeight == WEIGHT_LIMIT) {
                d.setWeight(newWeight);
                d.setState(State.LOADED);
            }
        });
        droneRepo.saveAndFlush(d);
        return messageCreator.createMessage(DRONE_LOADED);
    }

    public DroneDto mapToDto(Drone drone) {
        return DroneDto.builder()
                .serialNumber(drone.getSerialNumber())
                .model(drone.getModel())
                .weight(drone.getWeight())
                .battery(drone.getBattery())
                .state(drone.getState())
                .build();
    }
}
