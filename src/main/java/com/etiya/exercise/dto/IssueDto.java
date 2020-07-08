package com.etiya.exercise.dto;

import com.etiya.exercise.entity.IssueStatus;
import lombok.Data;

import java.util.Date;

@Data
public class IssueDto {
    private  long Id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assignee;
    private ProjectDto project;

}
