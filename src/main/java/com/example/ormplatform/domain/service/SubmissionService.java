package com.example.ormplatform.domain.service;

import com.example.ormplatform.domain.entity.Assignment;
import com.example.ormplatform.domain.entity.Submission;
import com.example.ormplatform.domain.entity.User;
import com.example.ormplatform.domain.repository.AssignmentRepository;
import com.example.ormplatform.domain.repository.SubmissionRepository;
import com.example.ormplatform.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;

    @Transactional
    public Submission submit(Long studentId, Long assignmentId, String content) {
        submissionRepository
                .findByStudentIdAndAssignmentId(studentId, assignmentId)
                .ifPresent(s -> {
                    throw new DataIntegrityViolationException(
                            "Submission already exists for this student and assignment"
                    );
                });

        User student = userRepository.findById(studentId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Student not found: " + studentId)
                );

        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Assignment not found: " + assignmentId)
                );

        Submission submission = Submission.builder()
                .student(student)
                .assignment(assignment)
                .content(content)
                .submittedAt(LocalDateTime.now())
                .build();

        return submissionRepository.save(submission);
    }

    @Transactional
    public Submission grade(Long submissionId, Integer score, String feedback) {
        Submission submission = submissionRepository.findById(submissionId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Submission not found: " + submissionId)
                );

        submission.setScore(score);
        submission.setFeedback(feedback);

        return submissionRepository.save(submission);
    }
}