package org.result.ResultManagementSystem.service;

import org.result.ResultManagementSystem.dto.ExamDto;

import java.util.List;

public interface ExamService {

    ExamDto createExam(ExamDto examDto);
    ExamDto getExamById(Long id);
    List<ExamDto> getAllExam();
    ExamDto updateExam(ExamDto examDto,Long id);
    void deleteExamById(Long id);
}

