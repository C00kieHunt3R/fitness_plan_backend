package org.ssau.fitness_plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssau.fitness_plan.dto.ExerciseDto;
import org.ssau.fitness_plan.service.ExerciseService;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;
    @GetMapping("/get-all")
    public List<ExerciseDto> findAll() {
        return exerciseService.findAll();
    }

    @PostMapping("/create")
    public ExerciseDto create(@RequestBody ExerciseDto dto) {
        return exerciseService.create(dto);
    }

    @PutMapping("/update")
    public ExerciseDto update(@RequestBody ExerciseDto dto) {
        return exerciseService.update(dto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        exerciseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
