package com.example.ormplatform.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "modules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private Integer orderIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "course_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_module_course")
    )
    private Course course;
    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Lesson> lessons = new java.util.ArrayList<>();
    @OneToOne(mappedBy = "module", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Quiz quiz;
}
