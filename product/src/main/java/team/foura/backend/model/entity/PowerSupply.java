package team.foura.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * @Author Arman Hakhverdyan
 *
 * Entity for PowerSupply
 */
    @Entity
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public class PowerSupply {

        @Id
        @Column(name = "name", nullable = false, updatable = false)
        @NotBlank(message = "Name must be provided")
        String name;

        @Column(name = "price_usd", nullable = false, updatable = false)
        @NotBlank(message = "Price USD must be provided")
        Double priceUSD;

        @Column(name = "form_factor", nullable = false, updatable = false)
        @NotBlank(message = "Form factor must be provided")
        String formFactor;

        @Column(name = "efficiency_rating", nullable = false, updatable = false)
        @NotBlank(message = "Efficiency rating must be provided")
        String efficiencyRating;

        @Column(name = "wattage", nullable = false, updatable = false)
        @NotBlank(message = "Wattage must be provided")
        Integer wattage;

        @Column(name = "modular", nullable = false, updatable = false)
        @NotBlank(message = "Modular must be provided")
        Boolean modular;

        @Column(name = "color")
        String color;

        @Column(name = "tdp", nullable = false, updatable = false)
        @NotBlank(message = "TDP must be provided")
        Integer tdp;
    }

