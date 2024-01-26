package org.musala.org.musala.dispactservice.repositories;

import org.musala.org.musala.dispactservice.models.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository  extends JpaRepository<Drone, String> {
}
