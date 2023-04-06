package org.ssau.fitness_plan.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exercise", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

}
