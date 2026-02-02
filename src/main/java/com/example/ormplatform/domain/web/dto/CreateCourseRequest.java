package com.example.ormplatform.domain.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCourseRequest {

    @NotBlank(message = "title is required")
    @Size(max = 255, message = "title must be <= 255 chars")
    private String title;

    @Size(max = 2000, message = "description must be <= 2000 chars")
    private String description;

    @NotNull(message = "teacherId is required")
    private Long teacherId;

    @NotNull(message = "categoryId is required")
    private Long categoryId;
}