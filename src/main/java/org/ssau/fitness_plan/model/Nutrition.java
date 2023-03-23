package org.ssau.fitness_plan.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.ssau.fitness_plan.model.enums.NutritionType;

@Entity
@Table(name = "name", schema = "public")
@Getter
@Setter
@Builder
public class Nutrition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "meal", nullable = false)
    @Enumerated(EnumType.STRING)
    private NutritionType type;
    @Column(name = "protein", columnDefinition = "decimal")
    private Double protein;
    @Column(name = "carbohydrates", columnDefinition = "decimal")
    private Double carbohydrates;
    @Column(name = "fat", columnDefinition = "decimal")
    private Double fat;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount owner;

    public Nutrition() {
    }

    public Nutrition(Long id, NutritionType type, Double protein, Double carbohydrates, Double fat, UserAccount owner) {
        this.id = id;
        this.type = type;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
        this.owner = owner;
    }
}
