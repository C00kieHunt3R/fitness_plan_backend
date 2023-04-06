package org.ssau.fitness_plan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssau.fitness_plan.dto.UserAccountDto;
import org.ssau.fitness_plan.exception.NoSuchEntityIdException;
import org.ssau.fitness_plan.model.FitnessPlan;
import org.ssau.fitness_plan.model.UserAccount;
import org.ssau.fitness_plan.repository.FitnessPlanRepository;
import org.ssau.fitness_plan.repository.UserAccountRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountService {
    @Autowired
    UserAccountRepository userRepository;
    @Autowired
    FitnessPlanRepository fitnessPlanRepository;

    public List<UserAccountDto> findAll() {
        List<UserAccountDto> dtoList = new ArrayList<>();
        for (UserAccount userAccount:
                userRepository.findAll()) {
            dtoList.add(UserAccountDto.fromEntity(userAccount));
        }
        return dtoList;
    }

    public UserAccountDto findById(Long id) {
        return UserAccountDto.fromEntity(getEntity(id));
    }

    public UserAccountDto create(UserAccountDto dto) {
        List<FitnessPlan> plans = fitnessPlanRepository.findAllById(dto.getFitnessPlansId());
        return UserAccountDto.fromEntity(userRepository.save(UserAccountDto.toEntity(dto, plans)));
    }

    public UserAccountDto update(UserAccountDto dto) {
        UserAccount userAccount = getEntity(dto.getId());
        //BeanUtils.copyProperties(dto, userAccount, "id");
        List<FitnessPlan> plans = fitnessPlanRepository.findAllById(dto.getFitnessPlansId());
        userAccount = UserAccountDto.toEntity(dto, plans);
        return UserAccountDto.fromEntity(userRepository.save(userAccount));
    }

    public void delete(Long id) {
//        UserAccount userAccount = UserAccountDto.toEntity(findById(id));
         if (userRepository.existsById(id)) {
             userRepository.deleteById(id);
         } else throw new NoSuchEntityIdException(UserAccount.class.getSimpleName(), id);
    }

    private UserAccount getEntity(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchEntityIdException(UserAccount.class.getSimpleName(), id);
        });
    }
}
