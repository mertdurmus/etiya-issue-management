package com.etiya.exercise.api;

import com.etiya.exercise.dto.ProjectDto;
import com.etiya.exercise.service.impl.ProjectServiceImpl;
import com.etiya.exercise.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getById")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value = "createProject")
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImpl.save(projectDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "updateProject")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id, @Valid  @RequestBody  ProjectDto projectDto){
        return ResponseEntity.ok(projectServiceImpl.update(id, projectDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
