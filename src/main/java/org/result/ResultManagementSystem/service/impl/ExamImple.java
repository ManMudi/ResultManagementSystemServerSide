package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.ExamDto;
import org.result.ResultManagementSystem.entity.Exam;
import org.result.ResultManagementSystem.mapper.ExamMapper;
import org.result.ResultManagementSystem.repository.ExamRepository;
import org.result.ResultManagementSystem.service.ExamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExamImple implements ExamService {
    private ExamRepository examRepository;
    @Override
    public ExamDto createExam(ExamDto examDto) {
        Exam exam= ExamMapper.mapToExam(examDto);
        Exam exam1=examRepository.save(exam);
        return ExamMapper.mapToExamDto(exam1);
    }

    @Override
    public ExamDto getExamById(Long id) {
        Exam exam=examRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Exam with given Idis not exist with given id : "+ id));
        return ExamMapper.mapToExamDto(exam);
    }

    @Override
    public List<ExamDto> getAllExam() {
        List<Exam> exams=examRepository.findAll();
        return exams.stream().map( (exam1)-> ExamMapper.mapToExamDto(exam1))
                .collect(Collectors.toList());
    }

    @Override
    public ExamDto updateExam(ExamDto examDto, Long id) {
        Exam exam=examRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Exam with given Id is not exist with given id : "+ id));
        exam.setExam(examDto.getExam());
        exam.setDescription(examDto.getDescription());
        Exam exam1=examRepository.save(exam);
        return ExamMapper.mapToExamDto(exam1);
    }

    @Override
    public void deleteExamById(Long id) {
        Exam exam=examRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Exam with given Id is not exist with given id : "+ id));
        examRepository.deleteById(id);

    }
}








