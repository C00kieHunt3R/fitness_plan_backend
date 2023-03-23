package org.ssau.fitness_plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssau.fitness_plan.dto.UserAccountDto;
import org.ssau.fitness_plan.service.UserAccountService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserAccountController {
    @Autowired
    UserAccountService accountService;

    @GetMapping("/get-all")
    public List<UserAccountDto> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/get")
    public UserAccountDto findById(@RequestParam Long id) {
        return accountService.findById(id);
    }

    @PostMapping("/create")
    public UserAccountDto create(@RequestBody UserAccountDto dto) {
        return accountService.create(dto);
    }

    @PutMapping("/update")
    public UserAccountDto update(@RequestBody UserAccountDto dto) {
        return accountService.update(dto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
