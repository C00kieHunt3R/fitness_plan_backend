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
    private String name;
    private NutritionType type;
    private Double protein;
    private Double carbohydrates;
    private Double fat;


    public static NutritionDto fromEntity(Nutrition nutrition) {
        return NutritionDto.builder()
                .id(nutrition.getId())
                .name(nutrition.getName())
                .type(nutrition.getType())
                .protein(nutrition.getProtein())
                .carbohydrates(nutrition.getCarbohydrates())
                .fat(nutrition.getFat())
                .build();
    }
    public static Nutrition toEntity(NutritionDto dto) {
        return Nutrition.builder()
                .id(dto.getId())
                .name(dto.getName())
                .type(dto.getType())
                .protein(dto.getProtein())
                .carbohydrates(dto.getCarbohydrates())
                .fat(dto.getFat())
                .build();
    }
}
