package org.musala.org.musala.dispactservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.musala.org.musala.dispactservice.dtos.MedicationDto;
import org.musala.org.musala.dispactservice.models.Medication;
import org.musala.org.musala.dispactservice.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/medications")
@RequiredArgsConstructor
@Slf4j
public class MedicationController {
    @Autowired
    private final MedicationService medicationService;

    @PostMapping
    public ResponseEntity<Medication> registerMedication(@RequestBody @Valid MedicationDto medicationDto) {
        return ResponseEntity.ok(medicationService.registerMedication(medicationDto));
    }
}
