package org.ssau.fitness_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssau.fitness_plan.model.FitnessPlan;

@Repository
public interface FitnessPlanRepository extends JpaRepository<FitnessPlan, Long> {
}
