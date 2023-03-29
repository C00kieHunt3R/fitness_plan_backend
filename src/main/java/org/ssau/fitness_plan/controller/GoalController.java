package org.ssau.fitness_plan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssau.fitness_plan.dto.GoalDto;
import org.ssau.fitness_plan.service.GoalService;

import java.util.List;

@RestController
@RequestMapping("/api/goal")
@CrossOrigin
public class GoalController {

    @Autowired
    GoalService goalService;

    @GetMapping("/get-all")
    public List<GoalDto> findAll() {
        return goalService.findAll();
    }

    @PostMapping("/create")
    public GoalDto create(@RequestBody GoalDto dto) {
        return goalService.create(dto);
    }

    @PutMapping("/update")
    public GoalDto update(@RequestBody GoalDto dto) {
        return goalService.update(dto);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Long id) {
        goalService.delete(id);
        return true;
    }
}
