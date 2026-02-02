package com.example.ormplatform.web.dto;

import java.time.LocalDate;

public record EnrollmentResponse(
        Long id,
        Long studentId,
        Long courseId,
        LocalDate enrolledAt
) {}