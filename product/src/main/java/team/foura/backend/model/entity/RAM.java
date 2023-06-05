package team.foura.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;


/**
 * @author Arman Hakhverdyan
 *
 * Entity for RAM
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class RAM {

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    private Long RAMId;

     @Id
     @Column(name = "name",nullable = false, updatable = false)
     @NotBlank(message = "name must be provided")
     String name;

     @Column(name = "price",nullable = false, updatable = false)
     @NotBlank(message = "price must be provided")
     double priceUSD;

     @Column(name = "speed",nullable = false, updatable = false)
     @NotBlank(message = "speed must be provided")
     int speed;

    @Column(name = "modules",nullable = false, updatable = false)
     @NotBlank(message = "modules must be provided")
     int modules;

     @Column(name = "color")
     String color;

     @Column(name = "firstWordLatency",nullable = false, updatable = false)
     @NotBlank(message = "firstWordLatency must be provided")
     int firstWordLatency;

     @Column(name = "casLatency",nullable = false, updatable = false)
     @NotBlank(message = "casLatency must be provided")
     int casLatency;

     @Column(name = "rgb")
     boolean rgb;
}
