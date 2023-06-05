package team.foura.backend.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * @author  Arman Hakhverdyan
 *
 * Entity for Motherboard
 */

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Motherboard {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long    motherboard_id;

    @NotBlank(message = "name must be provided")
    @Id
    @Column(name = "name", nullable = false, updatable = false)
    String  name;

    @NotBlank(message = "price must be provided")
    @Column(name = "price_usd", nullable = false, updatable = false)
    Double price;

    @NotBlank(message = "socket  must be provided")
    @Column(name = "socketCpu", nullable = false, updatable = false)
    String  socketCpu;

    @NotBlank(message = "chipset  must be provided")
    @Column(name = "chipSet", nullable = false, updatable = false)
    String  chipset;

    @NotBlank(message = "form factor must be provided")
    @Column(name = "formFactor", nullable = false, updatable = false)
    String  formFactor;

    @NotBlank(message = "memory max must be provided")
    @Column(name = "memoryMax", nullable = false, updatable = false)
    Integer memoryMax;

    @NotBlank(message = "memory slots must be provided")
    @Column(name = "memorySlots", nullable = false, updatable = false)
    Integer memorySlots;

    @NotBlank(message = "memory type must be provided")
    @Column(name = "memoryType", nullable = false, updatable = false)
    String  memoryType;

    @Column(name = "color", updatable = false)
    String  color;

    //todo Getter an Setter

}
