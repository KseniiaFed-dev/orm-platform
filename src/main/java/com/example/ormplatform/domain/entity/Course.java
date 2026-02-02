package com.example.ormplatform.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    // преподаватель курса
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "teacher_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_course_teacher")
    )
    private User teacher;

    // категория курса
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "category_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_course_category")
    )
    private Category category;

    // модули курса
    @OneToMany(
            mappedBy = "course",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Module> modules = new ArrayList<>();
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private java.util.List<Enrollment> enrollments = new java.util.ArrayList<>();
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private java.util.List<CourseReview> reviews = new java.util.ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "course_tag",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private java.util.Set<Tag> tags = new java.util.HashSet<>();
}
