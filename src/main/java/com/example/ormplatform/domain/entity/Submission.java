package com.example.ormplatform.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "submissions",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_submission_student_assignment",
                columnNames = {"student_id", "assignment_id"}
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "assignment_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_submission_assignment")
    )
    private Assignment assignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "student_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_submission_student")
    )
    private User student;

    private LocalDateTime submittedAt;

    @Column(length = 4000)
    private String content;

    private Integer score;

    @Column(length = 2000)
    private String feedback;
}
