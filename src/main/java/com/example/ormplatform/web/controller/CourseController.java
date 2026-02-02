package com.example.ormplatform.web.controller;

import com.example.ormplatform.domain.entity.Course;
import com.example.ormplatform.domain.entity.Lesson;
import com.example.ormplatform.domain.entity.Module;
import com.example.ormplatform.domain.service.CourseService;
import com.example.ormplatform.web.dto.CourseCreateRequest;
import com.example.ormplatform.web.dto.LessonCreateRequest;
import com.example.ormplatform.web.dto.ModuleCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@Valid @RequestBody CourseCreateRequest request) {
        return courseService.createCourse(
                request.getTitle(),
                request.getDescription(),
                request.getCategoryId(),
                request.getTeacherId()
        );
    }

    @PostMapping("/courses/{courseId}/modules")
    @ResponseStatus(HttpStatus.CREATED)
    public Module addModule(@PathVariable Long courseId,
                            @Valid @RequestBody ModuleCreateRequest request) {
        return courseService.addModule(courseId, request.getTitle(), request.getOrderIndex());
    }

    @PostMapping("/modules/{moduleId}/lessons")
    @ResponseStatus(HttpStatus.CREATED)
    public Lesson addLesson(@PathVariable Long moduleId,
                            @Valid @RequestBody LessonCreateRequest request) {
        return courseService.addLesson(
                moduleId,
                request.title(),
                request.content(),
                request.videoUrl()
        );
    }
}