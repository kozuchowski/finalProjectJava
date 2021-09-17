package com.beef.beef.model;

import lombok.Data;

import javax.persistence.*;

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

    private boolean waitingForTraining;
}
