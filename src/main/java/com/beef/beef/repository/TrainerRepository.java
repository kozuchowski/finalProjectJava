package com.beef.beef.repository;

import com.beef.beef.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Trainer findByLogin(String login);

}
