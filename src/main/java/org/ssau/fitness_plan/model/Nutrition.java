package org.ssau.fitness_plan.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.ssau.fitness_plan.model.enums.NutritionType;

import java.util.List;

@Entity
@Table(name = "nutrition", schema = "public")
@Getter
@Setter
@Builder
public class Nutrition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "meal", nullable = false)
    @Enumerated(EnumType.STRING)
    private NutritionType type;
    @Column(name = "protein", columnDefinition = "decimal")
    private Double protein;
    @Column(name = "carbohydrates", columnDefinition = "decimal")
    private Double carbohydrates;
    @Column(name = "fat", columnDefinition = "decimal")
    private Double fat;

    public Nutrition() {
    }

    public Nutrition(Long id, String name, NutritionType type, Double protein, Double carbohydrates, Double fat) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
    }
}
