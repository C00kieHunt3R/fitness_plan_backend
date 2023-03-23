package org.ssau.fitness_plan.dto;

import lombok.Builder;
import lombok.Data;
import org.ssau.fitness_plan.model.Nutrition;
import org.ssau.fitness_plan.model.enums.NutritionType;
import org.ssau.fitness_plan.model.UserAccount;
@Data
@Builder
public class NutritionDto {
    private Long id;
    private NutritionType type;
    private Double protein;
    private Double carbohydrates;
    private Double fat;

    private UserAccount owner;

    public static NutritionDto fromEntity(Nutrition nutrition) {
        return NutritionDto.builder()
                .id(nutrition.getId())
                .type(nutrition.getType())
                .protein(nutrition.getProtein())
                .carbohydrates(nutrition.getCarbohydrates())
                .fat(nutrition.getFat())
                .owner(nutrition.getOwner())
                .build();
    }
    public static Nutrition toEntity(NutritionDto dto) {
        return Nutrition.builder()
                .id(dto.getId())
                .type(dto.getType())
                .protein(dto.getProtein())
                .carbohydrates(dto.getCarbohydrates())
                .fat(dto.getFat())
                .owner(dto.getOwner())
                .build();
    }
}
