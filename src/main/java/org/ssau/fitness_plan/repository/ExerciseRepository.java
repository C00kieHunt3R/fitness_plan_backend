package org.ssau.fitness_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssau.fitness_plan.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
