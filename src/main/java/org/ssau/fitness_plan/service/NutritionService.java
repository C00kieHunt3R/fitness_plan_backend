package org.ssau.fitness_plan.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssau.fitness_plan.dto.NutritionDto;
import org.ssau.fitness_plan.exception.NoSuchEntityIdException;
import org.ssau.fitness_plan.model.Nutrition;
import org.ssau.fitness_plan.repository.NutritionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NutritionService {

    @Autowired
    NutritionRepository nutritionRepository;

    public List<NutritionDto> findAll() {
        List<NutritionDto> dtoList = new ArrayList<>();
        for (Nutrition nutrition:
             nutritionRepository.findAll()) {
            dtoList.add(NutritionDto.fromEntity(nutrition));
        }
        return dtoList;
    }

    public NutritionDto findById(Long id) {
        return NutritionDto.fromEntity(getEntity(id));
    }

    public NutritionDto create(NutritionDto dto) {
        return NutritionDto.fromEntity(nutritionRepository.save(NutritionDto.toEntity(dto)));
    }

    public NutritionDto update(NutritionDto dto) {
        Nutrition nutrition = getEntity(dto.getId());
        BeanUtils.copyProperties(dto, nutrition, "id");
        return NutritionDto.fromEntity(nutritionRepository.save(nutrition));
    }

    public void delete(Long id) {
        Nutrition nutrition = getEntity(id);
        nutritionRepository.deleteById(nutrition.getId());
    }
    private Nutrition getEntity(Long id) {
        return nutritionRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchEntityIdException(Nutrition.class.getSimpleName(), id);
        });
    }
}
