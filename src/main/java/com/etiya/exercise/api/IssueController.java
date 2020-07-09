package com.etiya.exercise.api;


import com.etiya.exercise.dto.IssueDto;
import com.etiya.exercise.service.impl.IssueServiceImpl;
import com.etiya.exercise.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = ApiPaths.IssueCtrl.CTRL, description = "Issue APIs")
public class IssueController {


  private final IssueServiceImpl issueServiceImpl;

  public IssueController(IssueServiceImpl issueServiceImpl) {
    this.issueServiceImpl = issueServiceImpl;
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "getById")
  public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id) {
    IssueDto issueDto = issueServiceImpl.getById(id);
    return ResponseEntity.ok(issueDto);
  }

  @PostMapping
  @ApiOperation(value = "createIssue")
  public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issueDto) {
    return ResponseEntity.ok( issueServiceImpl.save(issueDto));
  }

  @DeleteMapping("/{id}")
  @ApiOperation(value = "delete")
  public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
    return ResponseEntity.ok(issueServiceImpl.delete(id));
  }

}
