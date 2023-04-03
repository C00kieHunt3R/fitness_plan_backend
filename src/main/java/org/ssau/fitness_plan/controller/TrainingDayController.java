package org.ssau.fitness_plan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ssau.fitness_plan.dto.TrainingDayDto;
import org.ssau.fitness_plan.service.TrainingDayService;

import java.util.List;

@RestController
@RequestMapping("/api/training-day")
@CrossOrigin
public class TrainingDayController {

    @Autowired
    private TrainingDayService trainingDayService;

    @GetMapping("/get-all")
    public List<TrainingDayDto> findAll() {
        return trainingDayService.findAll();
    }

    @GetMapping("/get-list")
    public List<TrainingDayDto> findAllById(@RequestParam(value = "id") List<Long> identifiers) {
        return trainingDayService.findAllById(identifiers);
    }

    @PostMapping("/create")
    public TrainingDayDto create(@RequestBody TrainingDayDto dto) {
        return trainingDayService.create(dto);
    }

    @PutMapping("/update")
    public TrainingDayDto update(@RequestBody TrainingDayDto dto) {
        return trainingDayService.update(dto);
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam Long id) {
        trainingDayService.delete(id);
        return true;
    }


}
