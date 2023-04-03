package org.ssau.fitness_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssau.fitness_plan.model.TrainingDay;

@Repository
public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long> {

}
