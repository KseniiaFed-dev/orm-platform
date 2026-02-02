package com.example.ormplatform.web.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CourseResponse {
    Long id;
    String title;
    String description;
    Long teacherId;
    Long categoryId;
}