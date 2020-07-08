package com.etiya.exercise.repository;

import com.etiya.exercise.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IssueRepository extends JpaRepository<Issue, Long> {
}
