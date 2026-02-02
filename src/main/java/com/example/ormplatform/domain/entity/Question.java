package com.example.ormplatform.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2000)
    private String text;

    @Column(nullable = false)
    private String type; // SINGLE_CHOICE / MULTIPLE_CHOICE

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "quiz_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_question_quiz")
    )
    private Quiz quiz;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerOption> options = new ArrayList<>();
}