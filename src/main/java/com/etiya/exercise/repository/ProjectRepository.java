package com.etiya.exercise.repository;


import com.etiya.exercise.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> getAllByProjectCode(String projectCode);

    List<Project> getAllByProjectCodeAndIdNotNull(String projectCode);

    List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode, String projectName);

    Page<Project> findAll(Pageable pageable);

    Project getByProjectCode(String projectCode);

}
