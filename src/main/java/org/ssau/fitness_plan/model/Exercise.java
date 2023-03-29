package org.ssau.fitness_plan.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exercises", schema = "public")
@Getter
@Setter
@Builder
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", columnDefinition = "text", length = 100, nullable = false)
    private String name;
    @Column(name = "image", columnDefinition = "text")
    private String image;
    @Column(name = "reps", columnDefinition = "integer")
    private Integer reps;
    @Column(name = "sets", columnDefinition = "integer")
    private Integer sets;
    @Column(name = "weight", columnDefinition = "decimal")
    private Double weight;

    public Exercise() {}

    public Exercise(Long id, String name, String image, Integer reps, Integer sets, Double weight, List<Workout> workouts) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
        this.workouts = workouts;
    }


    @ManyToMany(mappedBy = "exercises", cascade = CascadeType.REFRESH)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Workout> workouts;

}
