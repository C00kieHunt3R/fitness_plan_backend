package org.ssau.fitness_plan.dto;


import lombok.Builder;
import lombok.Data;
import org.ssau.fitness_plan.model.Exercise;

@Data
@Builder
public class ExerciseDto {
    private Long id;
    private String name;
    private String image;
    private Integer reps;
    private Integer sets;
    private Double weight;
    public static ExerciseDto fromEntity(Exercise exercise) {
        return ExerciseDto.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .image(exercise.getImage())
                .reps(exercise.getReps())
                .sets(exercise.getSets())
                .weight(exercise.getWeight())
                .build();
    }
    public static Exercise toEntity(ExerciseDto exerciseDto) {
        return new Exercise(
                exerciseDto.getId(),
                exerciseDto.getName(),
                exerciseDto.getImage(),
                exerciseDto.getReps(),
                exerciseDto.getSets(),
                exerciseDto.getWeight()
        );
    }
}
