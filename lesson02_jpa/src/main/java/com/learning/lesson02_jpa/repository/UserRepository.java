package com.learning.lesson02_jpa.repository;

import com.learning.lesson02_jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
