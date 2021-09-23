package com.beef.beef.repository;
import com.beef.beef.model.Training;
import org.springframework.data.repository.CrudRepository;

public interface TrainingRepository extends CrudRepository<Training, Integer> {
    Training findByTrainingParticipantId(Integer id);
}