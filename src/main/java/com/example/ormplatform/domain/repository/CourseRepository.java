package com.example.ormplatform.domain.repository;

import com.example.ormplatform.domain.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCategoryId(Long categoryId);
    List<Course> findByTeacherId(Long teacherId);
}