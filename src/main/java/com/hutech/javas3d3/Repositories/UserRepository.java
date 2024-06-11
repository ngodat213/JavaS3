package com.hutech.javas3d3.Repositories;

import com.hutech.javas3d3.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username=?1")
    User findByUsername(String username);
}