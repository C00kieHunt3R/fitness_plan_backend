package org.ssau.fitness_plan.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "fitness_plan", schema = "public")
@Getter
@Setter
@Builder
public class FitnessPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "comment")
    private String comment;

    @Column(name = "image")
    private String image;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_day_id", referencedColumnName = "id")
    private List<TrainingDay> trainingDays;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private UserAccount owner;


    public FitnessPlan() {}

    public FitnessPlan(Long id, String name, String comment, String image, List<TrainingDay> trainingDays, UserAccount owner) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.image = image;
        this.trainingDays = trainingDays;
        this.owner = owner;
    }
}
