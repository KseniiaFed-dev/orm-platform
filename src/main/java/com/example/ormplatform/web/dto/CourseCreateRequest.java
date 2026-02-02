package com.example.ormplatform.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseCreateRequest {
    @NotBlank
    private String title;

    private String description;

    @NotNull
    private Long teacherId;

    @NotNull
    private Long categoryId;
}