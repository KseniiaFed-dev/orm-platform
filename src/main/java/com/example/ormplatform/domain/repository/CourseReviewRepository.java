package com.example.ormplatform.domain.repository;

import com.example.ormplatform.domain.entity.CourseReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseReviewRepository extends JpaRepository<CourseReview, Long> {

    Optional<CourseReview> findByCourseIdAndStudentId(Long courseId, Long studentId);

    List<CourseReview> findByCourseId(Long courseId);

    List<CourseReview> findByStudentId(Long studentId);
}