package team.foura.backend.model.dto;

/**
 *
 * @param name
 * @param priceUSD
 * @param formFactor
 * @param efficiencyRating
 * @param wattage
 * @param modular
 * @param color
 * @param tdp
 *
 * @author Arman Hakhverdyan
 *
 * DTO (Data Transfer Object) representing a power supply.
 */
public record PowerSupplyDTO(
        String name,
        double priceUSD,
        String formFactor,
        String efficiencyRating,
        int wattage,
        boolean modular,
        String color,
        int tdp
) {
}
