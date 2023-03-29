package org.ssau.fitness_plan.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssau.fitness_plan.dto.GoalDto;
import org.ssau.fitness_plan.dto.UserAccountDto;
import org.ssau.fitness_plan.exception.NoSuchEntityIdException;
import org.ssau.fitness_plan.model.Goal;
import org.ssau.fitness_plan.repository.GoalRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    public List<GoalDto> findAll() {
        List<GoalDto> dtoList = new ArrayList<>();
        for (Goal goal:
                goalRepository.findAll()) {
            dtoList.add(GoalDto.fromEntity(goal));
        }
        return dtoList;

    }
    public GoalDto findById(Long id) {
        return GoalDto.fromEntity(getEntity(id));
    }


    public GoalDto update(GoalDto dto) {
        Goal goal = getEntity(dto.getId());
        BeanUtils.copyProperties(dto, goal, "id", "started");
        //goal = GoalDto.toEntity(dto);
        //goal.setOwner(UserAccountDto.toEntity(accountService.findById(dto.getOwnerId())));
//        BeanUtils.copyProperties(dto, goal, "id");
        return GoalDto.fromEntity(goalRepository.save(goal));
    }

    public GoalDto create(GoalDto dto) {
        Goal goal = GoalDto.toEntity(dto);
        //goal.setOwner(UserAccountDto.toEntity(accountService.findById(dto.getOwnerId())));
        return GoalDto.fromEntity(goalRepository.save(goal));
    }

    public void delete(Long id) {
        Goal goal = getEntity(id);
        goalRepository.deleteById(goal.getId());
    }

    private Goal getEntity(Long id) {
        return goalRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchEntityIdException(Goal.class.getSimpleName(), id);
        });
    }
}
