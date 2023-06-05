package team.foura.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * @author Arman Hakhverdyan
 *
 * Entity for CPU
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CPU {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long cpuId;

    //It can be primary key, if can't be add @Table with uniqueConstrait name
    @Id
    @NotBlank(message = "name must be provided")
    @Column(name = "name", nullable = false, updatable = false)
    String     name;


    @NotBlank(message = "price must be provided")
    @Column(name = "price_usd", nullable = false, updatable = false)
    Double    price;

    @NotBlank(message = "core count must be provided")
    @Column(name = "core_count",nullable = false, updatable = false)
    Integer    coreCount;

    @NotBlank(message = "core clock must be provided")
    @Column(name = "core_clock", nullable = false, updatable = false)
    Integer    coreClock;

    @NotBlank(message = "boost clock must be provided")
    @Column(name = "boost_clock", nullable = false, updatable = false)
    Integer    boostClock;

    @NotBlank(message = "tdp must be provided")
    @Column(name = "tdp", nullable = false, updatable = false)
    Integer    tdp;

    @Column(name = "integrated_graphics", updatable = false)
    String     integratedGraphics;

    @NotBlank(message = "socket must be provided")
    @Column(name = "socket",nullable = false, updatable = false)
    String     socket;

    @NotBlank(message = "smt must be provided")
    @Column(name = "smt",nullable = false, updatable = false)
    String     smt;

    //todo Getter and Setter, Constructors, toString(?)

}
