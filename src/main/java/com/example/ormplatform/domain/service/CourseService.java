package com.example.ormplatform.domain.service;

import com.example.ormplatform.domain.entity.Category;
import com.example.ormplatform.domain.entity.Course;
import com.example.ormplatform.domain.entity.Lesson;
import com.example.ormplatform.domain.entity.Module;
import com.example.ormplatform.domain.entity.User;
import com.example.ormplatform.domain.repository.CategoryRepository;
import com.example.ormplatform.domain.repository.CourseRepository;
import com.example.ormplatform.domain.repository.LessonRepository;
import com.example.ormplatform.domain.repository.ModuleRepository;
import com.example.ormplatform.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    @Transactional
    public Course createCourse(String title, String description, Long teacherId, Long categoryId) {
        User teacher = userRepository.findById(teacherId)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found: " + teacherId));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found: " + categoryId));

        Course course = Course.builder()
                .title(title)
                .description(description)
                .teacher(teacher)
                .category(category)
                .build();

        return courseRepository.save(course);
    }

    @Transactional(readOnly = true)
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Course getById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found: " + id));
    }

    @Transactional
    public Module addModule(Long courseId, String title, Integer orderIndex) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found: " + courseId));

        Module module = Module.builder()
                .title(title)
                .orderIndex(orderIndex)
                .course(course)
                .build();

        return moduleRepository.save(module);
    }

    @Transactional
    public Lesson addLesson(Long moduleId, String title, String content, String videoUrl) {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new EntityNotFoundException("Module not found: " + moduleId));

        Lesson lesson = Lesson.builder()
                .title(title)
                .content(content)
                .videoUrl(videoUrl)
                .module(module)
                .build();

        return lessonRepository.save(lesson);
    }
}