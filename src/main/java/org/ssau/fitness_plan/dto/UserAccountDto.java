package org.ssau.fitness_plan.dto;

import lombok.Builder;
import lombok.Data;
import org.ssau.fitness_plan.model.UserAccount;
import org.ssau.fitness_plan.model.enums.Gender;

import java.util.Date;

@Data
@Builder
public class UserAccountDto {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private Integer weight;
    private Integer height;
    private Gender gender;
    private Date birthdate;
    private String email;

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
                .build();
    }

    public static UserAccount toEntity(UserAccountDto dto) {
        return UserAccount.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .age(dto.getAge())
                .weight(dto.getWeight())
                .height(dto.getHeight())
                .gender(dto.getGender())
                .birthdate(dto.getBirthdate())
                .email(dto.getEmail())
                .build();
    }

}
