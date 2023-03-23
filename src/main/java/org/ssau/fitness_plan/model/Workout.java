package org.ssau.fitness_plan.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workouts", schema = "public")
@Getter
@Setter
@Builder
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", columnDefinition = "text", length = 100, nullable = false)
    private String name;
    @Column(name = "comment", columnDefinition = "text")
    private String comment;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Exercise> exercises;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount owner;

    public Workout() {
    }

    public Workout(Long id, String name, String comment, Date date, List<Exercise> exercises, UserAccount owner) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.date = date;
        this.exercises = exercises;
        this.owner = owner;
    }
}
