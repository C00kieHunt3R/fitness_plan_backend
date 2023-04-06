package org.ssau.fitness_plan.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssau.fitness_plan.dto.WorkoutDto;
import org.ssau.fitness_plan.exception.NoSuchEntityIdException;
import org.ssau.fitness_plan.model.Exercise;
import org.ssau.fitness_plan.model.FitnessPlan;
import org.ssau.fitness_plan.model.Workout;
import org.ssau.fitness_plan.repository.ExerciseRepository;
import org.ssau.fitness_plan.repository.WorkoutRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {
    @Autowired
    WorkoutRepository workoutRepository;
    @Autowired
    ExerciseRepository exerciseRepository;

    public List<WorkoutDto> findAll() {
        List<WorkoutDto> dtoList = new ArrayList<>();
        for (Workout workout:
             workoutRepository.findAll()) {
            WorkoutDto dto = WorkoutDto.fromEntity(workout);
//            dto.setExercisesId(workout.getExercises());
//            dtoList.add(dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public WorkoutDto findById(Long id) {
        Workout workout = getEntity(id);
        //        dto.setExercisesId(workout.getExercises());
        return WorkoutDto.fromEntity(workout);
    }

    public WorkoutDto create(WorkoutDto dto) {
        List<Exercise> exercises = exerciseRepository.findAllById(dto.getExercisesId());
        Workout workout = WorkoutDto.toEntity(dto, exercises);
        return WorkoutDto.fromEntity(workoutRepository.save(workout));
        //return WorkoutDto.fromEntity(workoutRepository.save(WorkoutDto.toEntity(dto)));
    }

    public WorkoutDto update(WorkoutDto dto) {
        Workout workout = getEntity(dto.getId());
        BeanUtils.copyProperties(dto, workout, "id");
        return WorkoutDto.fromEntity(workoutRepository.save(workout));
    }

    public void delete(Long id) {
        Workout workout = getEntity(id);
        workoutRepository.deleteById(workout.getId());
    }

    private Workout getEntity(Long id) {
        return workoutRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchEntityIdException(Workout.class.getSimpleName(), id);
        });
    }

}
