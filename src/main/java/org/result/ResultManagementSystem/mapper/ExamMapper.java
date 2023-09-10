package org.result.ResultManagementSystem.mapper;

import org.result.ResultManagementSystem.dto.ExamDto;
import org.result.ResultManagementSystem.entity.Exam;

public class ExamMapper {
    public static ExamDto mapToExamDto(Exam exam){
        return new ExamDto(
                exam.getId(),
                exam.getExam().toUpperCase(),
                exam.getDescription()
        );
    }

    public static Exam mapToExam(ExamDto examDto){
        Exam exam=new Exam();
        exam.setId(examDto.getId());
        exam.setExam(examDto.getExam());
        exam.setDescription(examDto.getDescription());
        return exam;
    }
}
