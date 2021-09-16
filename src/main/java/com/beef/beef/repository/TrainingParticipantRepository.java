package com.beef.beef.repository;

import com.beef.beef.model.Trainer;
import com.beef.beef.model.TrainingParticipant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainingParticipantRepository extends JpaRepository<TrainingParticipant, Long> {
    TrainingParticipant findByLogin(String login);
}
