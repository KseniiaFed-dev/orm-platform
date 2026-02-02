package com.example.ormplatform.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "assignments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 4000)
    private String description;

    private LocalDate dueDate;

    private Integer maxScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "lesson_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_assignment_lesson")
    )
    private Lesson lesson;

    @OneToMany(mappedBy = "assignment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Submission> submissions = new ArrayList<>();
}
