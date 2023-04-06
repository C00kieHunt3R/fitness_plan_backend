package org.ssau.fitness_plan.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "fitness_plan", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FitnessPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "comment")
    private String comment;

    @Column(name = "image")
    private String image;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private List<TrainingDay> trainingDays;

//    @ManyToOne(cascade = CascadeType.REFRESH)
//    @OnDelete(action = OnDeleteAction.NO_ACTION)
//    private UserAccount owner;

}
