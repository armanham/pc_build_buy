package team.foura.backend.model.dto;


/**
 *
 * @param name
 * @param rating
 * @param ratingCount
 * @param priceUSD
 * @param speed
 * @param modules
 * @param priceGB
 * @param color
 * @param firstWordLatency
 * @param casLatency
 * @param rgb
 *
 * @author Arman Hakhverdyan
 *
 * An Immutable DataTransferObject of RAM for service layer.
 */
public record RamDTO(
        String name,
        double rating,
        int ratingCount,
        double priceUSD,
        int speed,
        int modules,
        double priceGB,
        String color,
        int firstWordLatency,
        int casLatency,
        boolean rgb
) {
}
