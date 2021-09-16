package com.beef.beef.model;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("u")
@Data
public class TrainingParticipant extends User {
    private int deadlift;

    private int squat;

    private int benchpress;

    @OneToOne
    private Training training;

    @ManyToOne
    private Trainer trainer;
}
