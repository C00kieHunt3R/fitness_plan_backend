package org.ssau.fitness_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssau.fitness_plan.model.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
