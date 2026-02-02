package com.example.ormplatform.web.controller;

import com.example.ormplatform.domain.entity.Submission;
import com.example.ormplatform.domain.service.SubmissionService;
import com.example.ormplatform.web.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping("/submissions")
    public SubmissionResponse submit(@Valid @RequestBody SubmissionCreateRequest req) {
        Submission s = submissionService.submit(req.studentId(), req.assignmentId(), req.content());
        return toResponse(s);
    }

    @PatchMapping("/submissions/{id}/grade")
    public SubmissionResponse grade(@PathVariable Long id, @Valid @RequestBody SubmissionGradeRequest req) {
        Submission s = submissionService.grade(id, req.score(), req.feedback());
        return toResponse(s);
    }

    private SubmissionResponse toResponse(Submission s) {
        return new SubmissionResponse(
                s.getId(),
                s.getStudent().getId(),
                s.getAssignment().getId(),
                s.getContent(),
                s.getScore(),
                s.getFeedback(),
                s.getSubmittedAt()
        );
    }
}