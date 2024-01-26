package org.musala.org.musala.dispactservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.musala.org.musala.dispactservice.enums.Model;
import org.musala.org.musala.dispactservice.enums.State;

import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DroneDto {
    @Size(min =  1, max =  100, message = "should contain 1 - 100 characters")
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private Model model;
    @Min(0)
    @Max(500)
    private Integer weight;
    @Min(0)
    @Max(100)
    private Integer battery;
    @Enumerated(EnumType.STRING)
    private State state;
}
