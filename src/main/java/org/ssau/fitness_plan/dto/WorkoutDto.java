package org.ssau.fitness_plan.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.ssau.fitness_plan.model.Exercise;
import org.ssau.fitness_plan.model.UserAccount;
import org.ssau.fitness_plan.model.Workout;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class WorkoutDto {
    private Long id;
    private String name;
    private String comment;
    private Date date;
    private List<Exercise> exercises;

    private UserAccount owner;

    public static WorkoutDto fromEntity(Workout workout) {
        return WorkoutDto.builder()
                .id(workout.getId())
                .name(workout.getName())
                .comment(workout.getComment())
                .date(workout.getDate())
                .exercises(workout.getExercises())
                .owner(workout.getOwner())
                .build();
    }
    public static Workout toEntity(WorkoutDto dto) {
        return Workout.builder()
                .id(dto.getId())
                .name(dto.getName())
                .comment(dto.getComment())
                .date(dto.getDate())
                .exercises(dto.getExercises())
                .owner(dto.getOwner())
                .build();
    }
}
