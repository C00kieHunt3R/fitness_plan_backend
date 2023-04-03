package org.ssau.fitness_plan.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.ssau.fitness_plan.model.enums.Gender;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_account", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Getter
@Setter
@Builder
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "text", length = 100, nullable = false)
    private String name;
    @Column(name = "surname", columnDefinition = "text", length = 100, nullable = false)
    private String surname;
    @Column(name = "age", columnDefinition = "integer")
    private Integer age;
    @Column(name = "weight", columnDefinition = "decimal")
    private Integer weight;
    @Column(name = "height", columnDefinition = "decimal")
    private Integer height;
    @Column(name = "gender", columnDefinition =  "text")
    private String gender;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    //@JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    @Column(name = "email", length = 254, unique = true)
    @Email
    private String email;

    public UserAccount() {
    }

    public UserAccount(Long id, String name, String surname, Integer age, Integer weight, Integer height, String gender, Date birthdate, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.birthdate = birthdate;
        this.email = email;
    }
    //    @OneToMany(fetch = FetchType.LAZY)
//    private List<Goal> goals;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Workout> workouts;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Nutrition> nutritions;


//    @OneToMany()
//    private List<Nutrition> nutritions;
//    @OneToMany()
//    private List<Goal> goals;
//    @OneToMany()
//    private List<Workout> workouts;
}
