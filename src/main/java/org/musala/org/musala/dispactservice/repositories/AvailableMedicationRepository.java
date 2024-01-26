package org.musala.org.musala.dispactservice.repositories;

import org.musala.org.musala.dispactservice.models.AvailableMedication;
import org.musala.org.musala.dispactservice.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableMedicationRepository extends JpaRepository<AvailableMedication, String> {
}
