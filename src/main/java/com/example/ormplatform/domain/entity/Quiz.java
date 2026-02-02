package com.example.ormplatform.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quizzes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private Integer timeLimit; // в минутах

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "module_id",
            nullable = false,
            unique = true,
            foreignKey = @ForeignKey(name = "fk_quiz_module")
    )
    private Module module;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    private List<QuizSubmission> submissions = new ArrayList<>();
}
