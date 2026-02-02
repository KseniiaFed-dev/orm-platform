package com.example.ormplatform.domain.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddModuleRequest {

    @NotBlank(message = "title is required")
    @Size(max = 255, message = "title must be <= 255 chars")
    private String title;

    @NotNull(message = "orderIndex is required")
    @PositiveOrZero(message = "orderIndex must be >= 0")
    private Integer orderIndex;
}