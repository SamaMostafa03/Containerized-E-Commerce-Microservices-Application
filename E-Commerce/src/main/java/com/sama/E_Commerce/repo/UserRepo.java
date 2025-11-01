package com.sama.E_Commerce.repo;

import com.sama.E_Commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String name);
}
