package com.example.ormplatform.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "enrollments",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_enrollment_user_course",
                columnNames = {"user_id", "course_id"}
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // студент
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_enrollment_user")
    )
    private User user;

    // курс
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "course_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_enrollment_course")
    )
    private Course course;

    private LocalDate enrolledAt;
}
