package com.example.ormplatform.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SubmissionCreateRequest(
        @NotNull Long studentId,
        @NotNull Long assignmentId,
        @NotBlank String content
) {}