package com.example.ormplatform.web.dto;

public record LessonResponse(
        Long id,
        String title,
        String content,
        String videoUrl,
        Long moduleId
) {}