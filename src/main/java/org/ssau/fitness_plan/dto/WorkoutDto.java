package org.ssau.fitness_plan.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.ssau.fitness_plan.model.Exercise;
import org.ssau.fitness_plan.model.UserAccount;
import org.ssau.fitness_plan.model.Workout;
import org.ssau.fitness_plan.service.ExerciseService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder

public class WorkoutDto {
    private Long id;
    private String name;
    private String comment;
    private String image;
    private Date date;
    private List<Long> exercisesId;

    public void setExercisesId(List<Exercise> exercises) {
        List<Long> identifiers = new ArrayList<>();
        exercises.forEach(exercise -> {
            identifiers.add(exercise.getId());
        });
        this.exercisesId = identifiers;
    }


    public static WorkoutDto fromEntity(Workout workout) {
        return WorkoutDto.builder()
                .id(workout.getId())
                .name(workout.getName())
                .comment(workout.getComment())
                .image(workout.getImage())
                .date(workout.getDate())
                .exercisesId(workout.getExercises().stream().map(Exercise::getId).toList())
                .build();
    }

    public static Workout toEntity(WorkoutDto dto, List<Exercise> exercises) {
        return new Workout(
                dto.getId(),
                dto.getName(),
                dto.getComment(),
                dto.getDate(),
                exercises,
                dto.getImage()
        );

    }
}
