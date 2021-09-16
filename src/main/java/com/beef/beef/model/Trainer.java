package com.beef.beef.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("t")
@Data
public class Trainer extends User {
    @OneToMany(mappedBy = "trainer")
    private List<TrainingParticipant> users;
}
