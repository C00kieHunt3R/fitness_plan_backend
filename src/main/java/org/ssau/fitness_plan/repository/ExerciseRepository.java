package org.ssau.fitness_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ssau.fitness_plan.model.Exercise;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    @Query(value = "select e from Exercise e where e.id not in (:identifiers)")
    List<Exercise> findAllByIdNot(@Param("identifiers") List<Long> identifiers);
}
