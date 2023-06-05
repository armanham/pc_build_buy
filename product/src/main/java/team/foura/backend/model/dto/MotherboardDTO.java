package team.foura.backend.model.dto;

/**
 *
 * @param name
 * @param price
 * @param socketCpu
 * @param chipset
 * @param formFactor
 * @param memoryMax
 * @param memorySlots
 * @param memoryType
 * @param color
 *
 * @author Arman Hakhverdyan
 *
 * An Immutable DataTransferObject of Motherboard for service layer.
 */
public record MotherboardDTO(
        String  name,
        Double price,
        String  socketCpu,
        String  chipset,
        String  formFactor,
        Integer memoryMax,
        Integer memorySlots,
        String  memoryType,
        String  color
) {

}
