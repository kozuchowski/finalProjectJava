package com.beef.beef.repository;

import com.beef.beef.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);
    User findById(int id);
}