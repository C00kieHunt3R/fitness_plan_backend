package org.ssau.fitness_plan.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "training_day", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "comment")
    private String comment;
    @Column(name = "image")
    private String image;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(referencedColumnName = "id")
    private Workout workout;


}
