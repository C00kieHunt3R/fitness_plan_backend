package org.ssau.fitness_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssau.fitness_plan.model.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
