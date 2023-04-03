package org.ssau.fitness_plan.dto;

import lombok.Builder;
import lombok.Data;
import org.ssau.fitness_plan.model.Nutrition;
import org.ssau.fitness_plan.model.TrainingDay;
import org.ssau.fitness_plan.model.Workout;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class TrainingDayDto {

    private Long id;

    private String name;

    private List<Long> workoutsId;

    private List<Long> nutritionId;

    public static TrainingDayDto fromEntity(TrainingDay trainingDay) {
        return TrainingDayDto.builder()
                .id(trainingDay.getId())
                .name(trainingDay.getName())
                .workoutsId(getWorkoutsId(trainingDay.getWorkouts()))
                .nutritionId(getNutritionId(trainingDay.getNutrition()))
                .build();
    }

    public static TrainingDay toEntity(TrainingDayDto dto, List<Workout> workouts, List<Nutrition> nutrition) {
        return TrainingDay.builder()
                .id(dto.getId())
                .name(dto.getName())
                .workouts(workouts)
                .nutrition(nutrition)
                .build();
    }

    private static List<Long> getWorkoutsId(List<Workout> workouts) {
        List<Long> identifiers = new ArrayList<>();
        workouts.forEach(workout -> {
            identifiers.add(workout.getId());
        });
        return identifiers;
    }
    private static List<Long> getNutritionId(List<Nutrition> nutrition) {
        List<Long> identifiers = new ArrayList<>();
        nutrition.forEach(nut -> {
            identifiers.add(nut.getId());
        });
        return identifiers;
    }
}
