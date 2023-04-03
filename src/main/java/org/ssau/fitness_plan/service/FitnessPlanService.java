package org.ssau.fitness_plan.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssau.fitness_plan.dto.FitnessPlanDto;
import org.ssau.fitness_plan.exception.NoSuchEntityIdException;
import org.ssau.fitness_plan.model.FitnessPlan;
import org.ssau.fitness_plan.repository.FitnessPlanRepository;
import org.ssau.fitness_plan.repository.TrainingDayRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FitnessPlanService {

    @Autowired
    private FitnessPlanRepository fitnessPlanRepository;
    @Autowired
    private TrainingDayRepository trainingDayRepository;

    public List<FitnessPlanDto> findAll() {
        List<FitnessPlanDto> dtoList = new ArrayList<>();
        fitnessPlanRepository.findAll().forEach(fitnessPlan -> {
            dtoList.add(FitnessPlanDto.fromEntity(fitnessPlan));
        });
        return dtoList;
    }

    public FitnessPlanDto create(FitnessPlanDto dto) {
        FitnessPlan fitnessPlan = FitnessPlanDto.toEntity(
                dto,
                trainingDayRepository.findAllById(dto.getTrainingDays())
        );
        return FitnessPlanDto.fromEntity(fitnessPlanRepository.save(fitnessPlan));
    }

    public FitnessPlanDto update(FitnessPlanDto dto) {
        FitnessPlan fitnessPlan = getEntity(dto.getId());
        BeanUtils.copyProperties(dto, fitnessPlan, "id", "daysId");
        fitnessPlan.setTrainingDays(trainingDayRepository.findAllById(dto.getTrainingDays()));
        return FitnessPlanDto.fromEntity(fitnessPlanRepository.save(fitnessPlan));
    }

    public void delete(Long id) {
        FitnessPlan fitnessPlan = getEntity(id);
        fitnessPlanRepository.deleteById(fitnessPlan.getId());
    }


    private FitnessPlan getEntity(Long id) {
        return fitnessPlanRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchEntityIdException(FitnessPlan.class.getSimpleName(), id);
        });
    }

}
