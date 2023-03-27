package com.maygul.assignment.question.q4;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agent extends AbstractEntity {

    @Column(name = "name", length = 127, nullable = false, unique = true)
    protected String name;

    @Column(nullable = false, length = 31)
    @Enumerated(EnumType.STRING)
    private AgentType type;

    @OneToOne
    @LazyToOne(value = LazyToOneOption.PROXY)
    @JoinColumn(name = "global_config_id")
    @JsonManagedReference
    private GlobalConfigData globalConfigData;

    @JsonManagedReference
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id")
    protected List<Route> routes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    protected List<Module> modules = new ArrayList<>();

    //getters and setters skipped for briefity.
}