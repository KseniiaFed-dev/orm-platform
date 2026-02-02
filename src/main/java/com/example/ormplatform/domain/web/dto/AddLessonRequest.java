package com.example.ormplatform.domain.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddLessonRequest {

    @NotBlank(message = "title is required")
    @Size(max = 255, message = "title must be <= 255 chars")
    private String title;

    @Size(max = 10000, message = "content must be <= 10000 chars")
    private String content;

    @Size(max = 500, message = "videoUrl must be <= 500 chars")
    private String videoUrl;
}