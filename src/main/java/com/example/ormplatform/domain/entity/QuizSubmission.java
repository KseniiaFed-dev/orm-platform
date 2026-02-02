package com.example.ormplatform.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "quiz_submissions",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_quiz_student",
                columnNames = {"quiz_id", "student_id"}
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "quiz_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_quiz_submission_quiz")
    )
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "student_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_quiz_submission_student")
    )
    private User student;

    private Integer score;

    private LocalDateTime takenAt;
}