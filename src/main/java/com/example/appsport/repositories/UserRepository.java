package com.example.appsport.repositories;

import com.example.appsport.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}
