package com.example.ormplatform.web.controller;

import com.example.ormplatform.domain.entity.Enrollment;
import com.example.ormplatform.domain.service.EnrollmentService;
import com.example.ormplatform.web.dto.EnrollmentCreateRequest;
import com.example.ormplatform.web.dto.EnrollmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/enrollments")
    public EnrollmentResponse enroll(@Valid @RequestBody EnrollmentCreateRequest req) {
        Enrollment e = enrollmentService.enroll(req.studentId(), req.courseId());
        return toResponse(e);
    }

    @DeleteMapping("/enrollments")
    public void unenroll(@RequestParam Long studentId, @RequestParam Long courseId) {
        enrollmentService.unenroll(studentId, courseId);
    }

    @GetMapping("/students/{studentId}/enrollments")
    public List<EnrollmentResponse> studentEnrollments(@PathVariable Long studentId) {
        return enrollmentService.getStudentEnrollments(studentId).stream().map(this::toResponse).toList();
    }

    @GetMapping("/courses/{courseId}/enrollments")
    public List<EnrollmentResponse> courseEnrollments(@PathVariable Long courseId) {
        return enrollmentService.getCourseEnrollments(courseId).stream().map(this::toResponse).toList();
    }

    private EnrollmentResponse toResponse(Enrollment e) {
        return new EnrollmentResponse(
                e.getId(),
                e.getUser().getId(),
                e.getCourse().getId(),
                e.getEnrolledAt()
        );
    }
}