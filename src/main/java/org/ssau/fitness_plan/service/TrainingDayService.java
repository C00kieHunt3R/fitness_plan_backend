package org.ssau.fitness_plan.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssau.fitness_plan.dto.TrainingDayDto;
import org.ssau.fitness_plan.exception.NoSuchEntityIdException;
import org.ssau.fitness_plan.model.FitnessPlan;
import org.ssau.fitness_plan.model.TrainingDay;
import org.ssau.fitness_plan.repository.NutritionRepository;
import org.ssau.fitness_plan.repository.FitnessPlanRepository;
import org.ssau.fitness_plan.repository.TrainingDayRepository;
import org.ssau.fitness_plan.repository.WorkoutRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingDayService {

    @Autowired
    private TrainingDayRepository trainingDayRepository;
    @Autowired
    private WorkoutRepository workoutRepository;
    @Autowired
    private NutritionRepository nutritionRepository;
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
                workoutRepository.findAllById(dto.getWorkoutsId()),
                nutritionRepository.findAllById(dto.getNutritionId())
        );
        return TrainingDayDto.fromEntity(trainingDayRepository.save(trainingDay));
    }

    public TrainingDayDto update(TrainingDayDto dto) {
        TrainingDay trainingDay = getEntity(dto.getId());
        BeanUtils.copyProperties(dto, trainingDay, "id", "workoutsId", "nutritionId");
        trainingDay.setWorkouts(workoutRepository.findAllById(dto.getWorkoutsId()));
        trainingDay.setNutrition(nutritionRepository.findAllById(dto.getNutritionId()));
        return TrainingDayDto.fromEntity(trainingDay);
    }

    public void delete(Long id) {
        TrainingDay trainingDay = getEntity(id);
        trainingDayRepository.deleteById(trainingDay.getId());
    }

    private TrainingDay getEntity(Long id) {
        return trainingDayRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchEntityIdException(TrainingDay.class.getSimpleName(), id);
        });
    }

    private FitnessPlan getSportPlanEntity(Long id) {
        return fitnessPlanRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchEntityIdException(FitnessPlan.class.getSimpleName(), id);
        });
    }
}
