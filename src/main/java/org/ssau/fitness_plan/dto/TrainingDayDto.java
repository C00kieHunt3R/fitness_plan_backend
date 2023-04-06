package org.ssau.fitness_plan.dto;

import lombok.Builder;
import lombok.Data;
import org.ssau.fitness_plan.model.TrainingDay;
import org.ssau.fitness_plan.model.Workout;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class TrainingDayDto {

    private Long id;

    private String name;
    private String comment;
    private String image;

    private Long workoutId;

    public static TrainingDayDto fromEntity(TrainingDay trainingDay) {
        return TrainingDayDto.builder()
                .id(trainingDay.getId())
                .name(trainingDay.getName())
                .comment(trainingDay.getComment())
                .image(trainingDay.getImage())
                .workoutId(trainingDay.getWorkout().getId())
                //.workoutsId(trainingDay.getWorkouts().stream().map(Workout::getId).toList())
                .build();
    }

    public static TrainingDay toEntity(TrainingDayDto dto, Workout workout) {
        return new TrainingDay(
          dto.getId(),
          dto.getName(),
          dto.getComment(),
          dto.getImage(),
          workout
        );
    }

    private static List<Long> getWorkoutsId(List<Workout> workouts) {
        List<Long> identifiers = new ArrayList<>();
        workouts.forEach(workout -> {
            identifiers.add(workout.getId());
        });
        return identifiers;
    }

}
