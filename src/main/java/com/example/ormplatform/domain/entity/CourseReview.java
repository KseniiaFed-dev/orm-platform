package com.example.ormplatform.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "course_reviews",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_review_course_student",
                columnNames = {"course_id", "student_id"}
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "course_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_review_course")
    )
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "student_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_review_student")
    )
    private User student;

    @Column(nullable = false)
    private Integer rating; // 1..5

    @Column(length = 2000)
    private String comment;

    private LocalDateTime createdAt;
}