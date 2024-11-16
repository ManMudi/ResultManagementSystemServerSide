package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.result.ResultManagementSystem.dto.ExamDto;
import org.result.ResultManagementSystem.entity.Exam;
import org.result.ResultManagementSystem.repository.ExamRepository;
import org.result.ResultManagementSystem.service.ExamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExamImple implements ExamService {
    private ExamRepository examRepository;
    private ModelMapper modelMapper;
    @Override
    public ExamDto createExam(ExamDto examDto) {
        Exam exam= modelMapper.map(examDto,Exam.class);
        Exam exam1=examRepository.save(exam);
        return modelMapper.map(exam1,ExamDto.class);
    }

    @Override
    public ExamDto getExamById(Long id) {
        Exam exam=examRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Exam with given Idis not exist with given id : "+ id));
        return modelMapper.map(exam,ExamDto.class);
    }

    @Override
    public List<ExamDto> getAllExam() {
        List<Exam> exams=examRepository.findAll();
        return exams.stream().map( (exam1)-> modelMapper.map(exam1,ExamDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ExamDto updateExam(ExamDto examDto, Long id) {
        Exam exam=examRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Exam with given Id is not exist with given id : "+ id));
        exam.setExam(examDto.getExam());
        exam.setDescription(examDto.getDescription());
        Exam exam1=examRepository.save(exam);
        return modelMapper.map(exam1,ExamDto.class);
    }

    @Override
    public void deleteExamById(Long id) {
        Exam exam=examRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Exam with given Id is not exist with given id : "+ id));
        examRepository.deleteById(id);

    }
}








