package com.beef.beef.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Training {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private TrainingParticipant trainingParticipant;


    @OneToMany(mappedBy = "training")
    private List<Exercise> exercises;
}
