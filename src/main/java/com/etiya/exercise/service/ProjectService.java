package com.etiya.exercise.service;

import com.etiya.exercise.dto.ProjectDto;
import com.etiya.exercise.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);

    List<Project> getAllByProjectCode(String projectCode);

    Boolean delete(Project project);

    Boolean delete(Long id);

    ProjectDto update(Long id, ProjectDto projectDto);
}
