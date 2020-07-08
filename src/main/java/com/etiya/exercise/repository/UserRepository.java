package com.etiya.exercise.repository;


import com.etiya.exercise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
