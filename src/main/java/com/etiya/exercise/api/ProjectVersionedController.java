package com.etiya.exercise.api;


import com.etiya.exercise.dto.ProjectDto;
import com.etiya.exercise.service.impl.ProjectServiceImpl;
import com.etiya.exercise.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versioning")
@Api(value = ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
public class ProjectVersionedController {

  @Autowired
  private ProjectServiceImpl projectService;


  @GetMapping(value = "/{id}", params = "version=1")
  @ApiOperation(value = "getById v1" ,response = ProjectDto.class)
  public ResponseEntity<ProjectDto> getByIdv1(@PathVariable("id") Long id) {
    ProjectDto projectDto = projectService.getById(id);
    return ResponseEntity.ok(projectDto);
  }


  @GetMapping(value = "/{id}", params = "version=2")
  @ApiOperation(value = "getById v2" ,response = ProjectDto.class)
  public ResponseEntity<ProjectDto> getByIdv2(@PathVariable("id") Long id) {
    ProjectDto projectDto = projectService.getById(id);
    return ResponseEntity.ok(projectDto);
  }

}
