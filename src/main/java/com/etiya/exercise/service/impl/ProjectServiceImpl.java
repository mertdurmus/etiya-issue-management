package com.etiya.exercise.service.impl;

import com.etiya.exercise.dto.ProjectDto;
import com.etiya.exercise.entity.Project;
import com.etiya.exercise.repository.ProjectRepository;
import com.etiya.exercise.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        if(project.getProjectCode()==null)
        {
            throw new IllegalArgumentException("Project code cant be null");
        }
        Project project1 = modelMapper.map(project, Project.class);
        return modelMapper.map(projectRepository.save(project1), ProjectDto.class);
    }

    @Override
    public ProjectDto getById(Long id) {

        Project project = projectRepository.getOne(id);
        return modelMapper.map(project, ProjectDto.class);

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

    @Override
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project projectCheck = projectRepository.getByProjectCode(projectDto.getProjectCode());

        Project project = projectRepository.getOne(id);
        if(project == null){
            throw  new IllegalArgumentException("Project does not exist");
        }
        if (projectCheck !=null && projectCheck.getId() != project.getId()){
            throw new IllegalArgumentException("Project code already exist");
        }
        project.setProjectCode(projectDto.getProjectCode());
        project.setProjectName(projectDto.getProjectName());
        projectRepository.save(project);
        return modelMapper.map(project, ProjectDto.class);

    }
}
