package com.example.ormplatform.web.dto;

import java.time.LocalDateTime;

public record SubmissionResponse(
        Long id,
        Long studentId,
        Long assignmentId,
        String content,
        Integer score,
        String feedback,
        LocalDateTime submittedAt
) {}