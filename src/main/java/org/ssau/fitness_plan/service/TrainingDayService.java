package org.ssau.fitness_plan.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssau.fitness_plan.dto.TrainingDayDto;
import org.ssau.fitness_plan.exception.NoSuchEntityIdException;
import org.ssau.fitness_plan.model.FitnessPlan;
import org.ssau.fitness_plan.model.TrainingDay;
import org.ssau.fitness_plan.model.Workout;
import org.ssau.fitness_plan.repository.FitnessPlanRepository;
import org.ssau.fitness_plan.repository.TrainingDayRepository;
import org.ssau.fitness_plan.repository.WorkoutRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainingDayService {

    @Autowired
    private TrainingDayRepository trainingDayRepository;
    @Autowired
    private WorkoutRepository workoutRepository;
    @Autowired
    private FitnessPlanRepository fitnessPlanRepository;

    public List<TrainingDayDto> findAll() {
        List<TrainingDayDto> dtoList = new ArrayList<>();
        trainingDayRepository.findAll().forEach(trainingDay -> {
            dtoList.add(TrainingDayDto.fromEntity(trainingDay));
        });
        return dtoList;
    }

    public List<TrainingDayDto> findAllById(List<Long> identifiers) {
        List<TrainingDayDto> dtoList = new ArrayList<>();
        trainingDayRepository.findAllById(identifiers).forEach(trainingDay -> {
            dtoList.add(TrainingDayDto.fromEntity(trainingDay));
        });
        return dtoList;
    }

    public TrainingDayDto create(TrainingDayDto dto) {
        TrainingDay trainingDay = TrainingDayDto.toEntity(
                dto,
                getWorkoutEntity(dto.getWorkoutId())
        );
        return TrainingDayDto.fromEntity(trainingDayRepository.save(trainingDay));
    }

    public TrainingDayDto update(TrainingDayDto dto) {
        TrainingDay trainingDay = getTrainingDayEntity(dto.getId());
        BeanUtils.copyProperties(dto, trainingDay, "id", "workoutId");
        //trainingDay.setWorkouts(workoutRepository.findAllById(dto.getWorkoutsId()));
        trainingDay.setWorkout(getWorkoutEntity(dto.getWorkoutId()));
        return TrainingDayDto.fromEntity(trainingDay);
    }

    public void delete(Long id) {
        TrainingDay trainingDay = getTrainingDayEntity(id);
        trainingDayRepository.deleteById(trainingDay.getId());
    }

    private TrainingDay getTrainingDayEntity(Long id) {
        return trainingDayRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchEntityIdException(TrainingDay.class.getSimpleName(), id);
        });
    }

    private FitnessPlan getSportPlanEntity(Long id) {
        return fitnessPlanRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchEntityIdException(FitnessPlan.class.getSimpleName(), id);
        });
    }

    private Workout getWorkoutEntity(Long id) {
        return workoutRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchEntityIdException(Workout.class.getSimpleName(), id);
        });
    }

    public List<TrainingDayDto> saveAll(List<TrainingDayDto> dtoList) {
        List<TrainingDayDto> ret = new ArrayList<>();
        dtoList.forEach(trainingDayDto -> {
            ret.add(TrainingDayDto.fromEntity(
                    trainingDayRepository.save(
                            TrainingDayDto.toEntity(
                                    trainingDayDto, getWorkoutEntity(trainingDayDto.getWorkoutId()
                                    )
                            )
                    )
            )
            );
        });
        return ret;
    }
}
