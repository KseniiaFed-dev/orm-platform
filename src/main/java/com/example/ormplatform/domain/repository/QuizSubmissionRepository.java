package com.example.ormplatform.domain.repository;

import com.example.ormplatform.domain.entity.QuizSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuizSubmissionRepository extends JpaRepository<QuizSubmission, Long> {

    Optional<QuizSubmission> findByQuizIdAndStudentId(Long quizId, Long studentId);

    List<QuizSubmission> findByStudentId(Long studentId);

    List<QuizSubmission> findByQuizId(Long quizId);
}