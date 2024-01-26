package org.musala.org.musala.dispactservice.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "available_medications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvailableMedication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "please provide the code of the medication")
    @Pattern(regexp = "[A-Z0-9_]+", message = "only upper case letters, underscore and numbers are allowed")
    private String medication_code;
    @Size(min =  1, max =  100, message = "should contain 1 - 100 characters")
    private String drone;
}
