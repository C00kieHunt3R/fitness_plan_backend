package org.ssau.fitness_plan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.ssau.fitness_plan.model.FitnessPlan;
import org.ssau.fitness_plan.model.UserAccount;
import org.ssau.fitness_plan.model.enums.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@Data
@Builder
public class UserAccountDto {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private Integer weight;
    private Integer height;
    private String gender;
    private Date birthdate;
    private String email;
    private List<Long> fitnessPlansId;

    public static UserAccountDto fromEntity(UserAccount userAccount) {
        return UserAccountDto.builder()
                .id(userAccount.getId())
                .name(userAccount.getName())
                .surname(userAccount.getSurname())
                .age(userAccount.getAge())
                .weight(userAccount.getWeight())
                .height(userAccount.getHeight())
                .gender(userAccount.getGender())
                .birthdate(userAccount.getBirthdate())
                .email(userAccount.getEmail())
                .fitnessPlansId(userAccount.getFitnessPlans().stream().map(FitnessPlan::getId).toList())
                .build();
    }

    public static UserAccount toEntity(UserAccountDto dto, List<FitnessPlan> plans) {
        return new UserAccount(
                dto.getId(),
                dto.getName(),
                dto.getSurname(),
                dto.getAge(),
                dto.getWeight(),
                dto.getHeight(),
                dto.getGender(),
                dto.getBirthdate(),
                dto.getEmail(),
                plans
        );
    }

}
