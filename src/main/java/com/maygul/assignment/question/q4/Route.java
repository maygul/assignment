package com.maygul.assignment.question.q4;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route extends AbstractEntity {

    @NaturalId
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "agent_id")
    @JsonBackReference
    private Agent agent;

    @NaturalId
    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "priority")
    private Integer priority;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id")
    @JsonManagedReference
    private List<ModuleRoute> moduleRoutes = new ArrayList<>();

    //getters and setters skipped for briefity.
}
