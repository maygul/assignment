package com.maygul.assignment.question.q4;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

import static javax.persistence.CascadeType.DETACH;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Module extends AbstractEntity {

    @NaturalId
    @ManyToOne(cascade = DETACH)
    @JoinColumn(name = "agent_id")
    @JsonBackReference
    private Agent agent;

    @NaturalId
    @Column(name = "name", length = 128)
    private String name;

    @JsonBackReference
    @Column(nullable = false, length = 31)
    @Enumerated(EnumType.STRING)
    private ModuleType type;

    //getters and setters skipped for briefity.
}