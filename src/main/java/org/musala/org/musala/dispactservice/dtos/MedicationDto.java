package org.musala.org.musala.dispactservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationDto {
    @NotNull(message = "please provide the code of the medication")
    @Pattern(regexp = "[A-Z0-9_]+", message = "only upper case letters, underscore and numbers are allowed")
    private String code;
    @NotNull(message = "please provide the name of the medication")
    @Pattern(regexp = "[a-zA-Z_0-9-]+", message = "only letters, numbers, underscore and hyphen are allowed")
    private String name;
    private String picture;
    @Positive(message = "please provide the valid value for the weight of the medication")
    private Integer weight;
}
