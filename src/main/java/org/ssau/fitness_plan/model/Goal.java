package org.ssau.fitness_plan.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@Entity
@Table(name = "goals", schema = "public")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", columnDefinition = "text", length = 100, nullable = false)
    private String name;
    @Column(name = "comment", columnDefinition = "text")
    private String comment;
    @Column(name = "started", updatable = false, nullable = false)
    @CreatedDate
    private Date started;
    @Column(name = "completed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completed;
    @Column(name = "image", columnDefinition = "text")
    private String image;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumns({
//            @JoinColumn(name = "owner_name", referencedColumnName = "name"),
//            @JoinColumn(name = "owner_surname", referencedColumnName = "surname")
//    })
//    private UserAccount owner;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserAccount owner;


    public Goal() {

    }

    public Goal(Long id, String name, String comment, Date started, Date completed, String image, UserAccount owner) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.started = started;
        this.completed = completed;
        this.image = image;
        this.owner = owner;
    }
}
