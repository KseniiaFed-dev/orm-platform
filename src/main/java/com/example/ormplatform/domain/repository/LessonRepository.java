package com.example.ormplatform.domain.repository;

import com.example.ormplatform.domain.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByModuleId(Long moduleId);
}