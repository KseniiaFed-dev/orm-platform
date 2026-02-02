package com.example.ormplatform.domain.entity;

import com.example.ormplatform.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_users_email",
                columnNames = "email"
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Profile profile;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private java.util.List<Enrollment> enrollments = new java.util.ArrayList<>();
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private java.util.List<Submission> submissions = new java.util.ArrayList<>();
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private java.util.List<QuizSubmission> quizSubmissions = new java.util.ArrayList<>();
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private java.util.List<CourseReview> reviews = new java.util.ArrayList<>();
}
