package org.ssau.fitness_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssau.fitness_plan.model.Nutrition;

public interface NutritionRepository extends JpaRepository<Nutrition, Long> {
}
