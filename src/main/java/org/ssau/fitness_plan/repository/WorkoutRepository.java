package org.ssau.fitness_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ssau.fitness_plan.model.Exercise;
import org.ssau.fitness_plan.model.Workout;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {


}
