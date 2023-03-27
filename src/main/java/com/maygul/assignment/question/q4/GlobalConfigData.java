package com.maygul.assignment.question.q4;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class GlobalConfigData extends AbstractEntity {

    @Column(name = "global_config", length = 312312312)
    @Lob
    protected String globalConfig;

    @OneToOne
    @LazyToOne(value = LazyToOneOption.PROXY)
    @JoinColumn(name = "agent_id")
    @JsonBackReference
    private Agent agent;
}
