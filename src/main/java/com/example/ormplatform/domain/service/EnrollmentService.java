package com.example.ormplatform.domain.service;

import com.example.ormplatform.domain.entity.Course;
import com.example.ormplatform.domain.entity.Enrollment;
import com.example.ormplatform.domain.entity.User;
import com.example.ormplatform.domain.repository.CourseRepository;
import com.example.ormplatform.domain.repository.EnrollmentRepository;
import com.example.ormplatform.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public Enrollment enroll(Long studentId, Long courseId) {
        // проверка уникальности на уровне приложения (и в БД тоже есть constraint)
        enrollmentRepository.findByUserIdAndCourseId(studentId, courseId).ifPresent(e -> {
            throw new DataIntegrityViolationException("Student already enrolled");
        });

        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found: " + courseId));

        Enrollment enrollment = Enrollment.builder()
                .user(student)
                .course(course)
                .enrolledAt(LocalDate.now())
                .build();

        return enrollmentRepository.save(enrollment);
    }

    @Transactional
    public void unenroll(Long studentId, Long courseId) {
        Enrollment enrollment = enrollmentRepository.findByUserIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new EntityNotFoundException("Enrollment not found for student=" + studentId + " course=" + courseId));

        enrollmentRepository.delete(enrollment);
    }

    @Transactional(readOnly = true)
    public List<Enrollment> getStudentEnrollments(Long studentId) {
        return enrollmentRepository.findByUserId(studentId);
    }

    @Transactional(readOnly = true)
    public List<Enrollment> getCourseEnrollments(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }
}