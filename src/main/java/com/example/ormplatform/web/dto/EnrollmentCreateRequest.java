package com.example.ormplatform.web.dto;

import jakarta.validation.constraints.NotNull;

public record EnrollmentCreateRequest(
        @NotNull Long studentId,
        @NotNull Long courseId
) {}