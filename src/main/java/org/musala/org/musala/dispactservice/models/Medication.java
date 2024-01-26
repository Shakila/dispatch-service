package org.musala.org.musala.dispactservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "medications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medication {
    @Id
    @Pattern(regexp = "[A-Z0-9_]+", message = "only upper case letters, underscore and numbers are allowed")
    private String code;
    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z_0-9-]+", message = "only letters, numbers, underscore and hyphen are allowed")
    private String name;
    private String picture;
    @Column (nullable = false)
    private Integer weight;
}
