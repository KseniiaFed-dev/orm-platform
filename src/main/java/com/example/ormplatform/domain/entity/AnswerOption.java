package com.example.ormplatform.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answer_options")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private boolean isCorrect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "question_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_option_question")
    )
    private Question question;
}