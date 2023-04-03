package org.ssau.fitness_plan.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "training_day", schema = "public")
@Getter
@Setter
@Builder
public class TrainingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.REFRESH)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "workout_id", referencedColumnName = "id")
    private List<Workout> workouts;

    @OneToMany(cascade = CascadeType.REFRESH)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "nutrition_id", referencedColumnName = "id")
    private List<Nutrition> nutrition;


    public TrainingDay() {}

    public TrainingDay(Long id, String name, List<Workout> workouts, List<Nutrition> nutrition) {
        this.id = id;
        this.name = name;
        this.workouts = workouts;
        this.nutrition = nutrition;
    }
}
