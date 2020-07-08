package com.etiya.exercise.service.impl;

import com.etiya.exercise.entity.Project;
import com.etiya.exercise.repository.ProjectRepository;
import com.etiya.exercise.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        if(project.getProjectCode()==null)
        {
            throw new IllegalArgumentException("Project code cant be null");
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public List<Project> getAllByProjectCode(String projectCode) {
        return projectRepository.getAllByProjectCode(projectCode);
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return Boolean.TRUE;
    }
}
