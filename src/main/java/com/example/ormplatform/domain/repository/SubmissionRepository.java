package com.example.ormplatform.domain.repository;

import com.example.ormplatform.domain.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    Optional<Submission> findByStudentIdAndAssignmentId(Long studentId, Long assignmentId);

    List<Submission> findByAssignmentId(Long assignmentId);

    List<Submission> findByStudentId(Long studentId);
}