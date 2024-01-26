package org.musala.org.musala.dispactservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.musala.org.musala.dispactservice.enums.Model;
import org.musala.org.musala.dispactservice.enums.State;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "drones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Drone {

    @Id
    @Size(min =  1, max =  100, message = "should contain 1 - 100 characters")
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private Model model;
    @Column(nullable = false)
    @Min(0)
    @Max(500)
    private Integer weight;
    @Column (nullable = false)
    @Min(0)
    @Max(100)
    private Integer battery;
    @Enumerated(EnumType.STRING)
    private State state;
}
