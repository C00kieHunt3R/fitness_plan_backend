package org.ssau.fitness_plan.dto;

import lombok.Builder;
import lombok.Data;
import org.ssau.fitness_plan.model.Goal;
import org.ssau.fitness_plan.model.UserAccount;

import java.util.Date;

@Data
@Builder
public class GoalDto {

    private Long id;
    private String name;
    private String comment;
    private Date started;
    private Date completed;
    private String image;

    public static GoalDto fromEntity(Goal goal) {
        return GoalDto.builder()
                .id(goal.getId())
                .name(goal.getName())
                .comment(goal.getComment())
                .started(goal.getStarted())
                .completed(goal.getCompleted())
                .image(goal.getImage())
                .build();
    }
    public static Goal toEntity(GoalDto dto) {
        return Goal.builder()
                .id(dto.getId())
                .name(dto.getName())
                .comment(dto.getComment())
                .started(dto.getStarted())
                .completed(dto.getCompleted())
                .image(dto.getImage())
                .build();
    }
}
