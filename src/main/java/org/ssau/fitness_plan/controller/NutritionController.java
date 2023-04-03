package org.ssau.fitness_plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssau.fitness_plan.dto.NutritionDto;
import org.ssau.fitness_plan.service.NutritionService;

import java.util.List;

@RestController
@RequestMapping("/api/nutrition")
@CrossOrigin
public class NutritionController {

    @Autowired
    NutritionService nutritionService;

    @GetMapping("/get-all")
    public List<NutritionDto> findAll() {
        return nutritionService.findAll();
    }

    @GetMapping("/get")
    public NutritionDto findById(@RequestParam Long id) {
        return nutritionService.findById(id);
    }

    @PostMapping("/create")
    public NutritionDto create(@RequestBody NutritionDto dto) {
        return nutritionService.create(dto);
    }

    @PutMapping("/update")
    public NutritionDto update(@RequestBody NutritionDto dto) {
        return nutritionService.update(dto);
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam Long id) {
        nutritionService.delete(id);
        return true;
    }
}
