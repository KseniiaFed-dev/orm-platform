package com.example.ormplatform.web.dto;

public record ModuleResponse(
        Long id,
        String title,
        Integer orderIndex,
        Long courseId
) {}