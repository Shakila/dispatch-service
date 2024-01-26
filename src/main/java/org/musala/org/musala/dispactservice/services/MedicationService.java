package org.musala.org.musala.dispactservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.musala.org.musala.dispactservice.dtos.MedicationDto;
import org.musala.org.musala.dispactservice.models.Medication;
import org.musala.org.musala.dispactservice.repositories.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MedicationService {
    @Autowired
    private final MedicationRepository mRepo;

    public Medication registerMedication(MedicationDto medicationDto) {
        Medication medication = Medication.builder()
                .code(medicationDto.getCode())
                .name(medicationDto.getName())
                .weight(medicationDto.getWeight())
                .picture(medicationDto.getPicture())
                .build();
        return mRepo.saveAndFlush(medication);
    }
}
