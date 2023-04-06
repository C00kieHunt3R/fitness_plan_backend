package org.ssau.fitness_plan.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workout", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name", columnDefinition = "text", length = 100, nullable = false)
    private String name;
    @Column(name = "comment", columnDefinition = "text")
    private String comment;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(referencedColumnName = "id")
    private List<Exercise> exercises;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private TrainingDay trainingDay;


    @Column(name = "image")
    private String image;


}
