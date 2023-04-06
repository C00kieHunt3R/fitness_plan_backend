package org.ssau.fitness_plan.dto;

import lombok.Builder;
import lombok.Data;
import org.ssau.fitness_plan.model.FitnessPlan;
import org.ssau.fitness_plan.model.TrainingDay;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class FitnessPlanDto {

    private Long id;

    private String name;
    private String comment;

    private String image;

    private List<Long> trainingDays;

    public static FitnessPlanDto fromEntity(FitnessPlan fitnessPlan) {
        return FitnessPlanDto.builder()
                .id(fitnessPlan.getId())
                .name(fitnessPlan.getName())
                .comment(fitnessPlan.getComment())
                .image(fitnessPlan.getImage())
                .trainingDays(getTrainingDays(fitnessPlan.getTrainingDays()))
                .build();
    }

    public static FitnessPlan toEntity(FitnessPlanDto dto, List<TrainingDay> trainingDays) {
        return new FitnessPlan(
                dto.getId(),
                dto.getName(),
                dto.getComment(),
                dto.getImage(),
                trainingDays
        );
    }

    private static List<Long> getTrainingDays(List<TrainingDay> trainingDays) {
        List<Long> identifiers = new ArrayList<>();
        trainingDays.forEach(trainingDay -> {
            identifiers.add(trainingDay.getId());
        });
        return identifiers;
    }

}
