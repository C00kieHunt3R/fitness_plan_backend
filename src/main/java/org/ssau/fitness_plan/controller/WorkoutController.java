package org.ssau.fitness_plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssau.fitness_plan.dto.WorkoutDto;
import org.ssau.fitness_plan.service.WorkoutService;

import java.util.List;

@RestController
@RequestMapping("/api/workout")
@CrossOrigin
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @GetMapping("/get-all")
    public List<WorkoutDto> findAll() {
        return workoutService.findAll();
    }

    @GetMapping("/get")
    public WorkoutDto findById(@RequestParam Long id) {
        return workoutService.findById(id);
    }

    @PostMapping("/create")
    public WorkoutDto create(@RequestBody WorkoutDto dto) {
        return workoutService.create(dto);
    }

    @PutMapping("/update")
    public WorkoutDto update(@RequestBody WorkoutDto dto) {
        return workoutService.update(dto);
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam Long id) {
        workoutService.delete(id);
        return true;
    }

}
