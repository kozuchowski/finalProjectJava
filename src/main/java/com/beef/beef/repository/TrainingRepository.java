package com.beef.beef.repository;
import com.beef.beef.model.Training;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TrainingRepository extends CrudRepository<Training, Integer> {
    Training findByTrainingParticipantId(Integer id);
}