package com.etiya.exercise.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;


@Data
@ApiModel
public class ProjectDto {

    @ApiModelProperty(value = "project id")
    private Long id;
    @NotNull
    @ApiModelProperty(required = true,value = "projectName")
    private String projectName;
    @ApiModelProperty(value = "projectCode")
    private String projectCode;
}
