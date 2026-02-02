package com.example.ormplatform.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LessonCreateRequest(
        @NotBlank String title,
        String content,
        String videoUrl,
        @NotNull Long moduleId
) {}