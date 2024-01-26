package org.musala.org.musala.dispactservice.dtos;

import lombok.*;
import org.musala.org.musala.dispactservice.enums.Model;
import org.musala.org.musala.dispactservice.enums.State;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DroneLoadingDto {
    @Size(min =  1, max =  100, message = "should contain 1 - 100 characters")
    private String drone;
    @NotNull(message = "please provide the code of the medication")
    @Pattern(regexp = "[A-Z0-9_]+", message = "only upper case letters, underscore and numbers are allowed")
    private String medicationCode;
}
