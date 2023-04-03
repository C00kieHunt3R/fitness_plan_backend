package org.ssau.fitness_plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ssau.fitness_plan.dto.FitnessPlanDto;
import org.ssau.fitness_plan.service.FitnessPlanService;

import java.util.List;

@RestController
@RequestMapping("/api/fitness-plan")
@CrossOrigin
public class FitnessPlanController {

    @Autowired
    private FitnessPlanService fitnessPlanService;

    @GetMapping("/get-all")
    public List<FitnessPlanDto> findAll() {
        return fitnessPlanService.findAll();
    }

    @PostMapping("/create")
    public FitnessPlanDto create(@RequestBody FitnessPlanDto dto) {
        return fitnessPlanService.create(dto);
    }

    @PutMapping("/update")
    public FitnessPlanDto update(@RequestBody FitnessPlanDto dto) {
        return fitnessPlanService.update(dto);
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam Long id) {
        fitnessPlanService.delete(id);
        return true;
    }
}
