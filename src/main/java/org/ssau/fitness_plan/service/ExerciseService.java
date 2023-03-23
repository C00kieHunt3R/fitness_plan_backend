package org.ssau.fitness_plan.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssau.fitness_plan.dto.ExerciseDto;
import org.ssau.fitness_plan.exception.NoSuchEntityIdException;
import org.ssau.fitness_plan.model.Exercise;
import org.ssau.fitness_plan.repository.ExerciseRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<ExerciseDto> findAll() {
        List<ExerciseDto> dtoList = new ArrayList<>();
        for (Exercise exercise : exerciseRepository.findAll()) {
            dtoList.add(ExerciseDto.fromEntity(exercise));
        }
        return dtoList;
    }

    public ExerciseDto findById(Long id) {
        return ExerciseDto.fromEntity(getEntity(id));
    }

    public ExerciseDto create(ExerciseDto dto) {
        return ExerciseDto.fromEntity(exerciseRepository.save(ExerciseDto.toEntity(dto)));
    }

    public ExerciseDto update(ExerciseDto dto) {
        Exercise exercise = getEntity(dto.getId());
        BeanUtils.copyProperties(dto, exercise, "id");
        return ExerciseDto.fromEntity(exerciseRepository.save(exercise));
    }


    public void delete(Long id) {
        Exercise exercise = getEntity(id);
        exerciseRepository.deleteById(exercise.getId());
    }

    private Exercise getEntity(Long id) {
        return exerciseRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchEntityIdException(Exercise.class.getSimpleName(), id);
        });
    }

    private byte[] getSerializedImage(String path) {
        try {
            return Base64.getDecoder().decode(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            return null;
        }
    }

}
