package org.musala.org.musala.dispactservice.repositories;

import org.musala.org.musala.dispactservice.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, String> {
}
