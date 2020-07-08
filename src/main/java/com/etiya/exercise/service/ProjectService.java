package com.etiya.exercise.service;

import com.etiya.exercise.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);

    List<Project> getAllByProjectCode(String projectCode);

    Boolean delete(Project project);
}
