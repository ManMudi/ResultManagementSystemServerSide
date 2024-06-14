package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.MarkDto;
import org.result.ResultManagementSystem.entity.*;
import org.result.ResultManagementSystem.mapper.MarkMapper;
import org.result.ResultManagementSystem.repository.*;
import org.result.ResultManagementSystem.service.MarkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MarkServiceImple implements MarkService {
    private MarkRepository markRepository;
    private SubjectRepository subjectRepository;
    private ExamRepository examRepository;
    private TermRepository termRepository;
    private YearRepository yearRepository;
    private StudentRepository studentRepository;

    @Override
    public MarkDto createMark(MarkDto markDto) {
        Mark mark= MarkMapper.mapToMark(markDto);
        Subject subject=subjectRepository.findById(markDto.getSubjectId()).orElseThrow(
                ()->new RuntimeException("Subject of this Id is not Found "+ markDto.getSubjectId()));
        mark.setSubject(subject);
        Exam exam=examRepository.findById(markDto.getExamId()).orElseThrow(
                ()->new RuntimeException("Exam of this Id is not Found "+ markDto.getExamId()));
        mark.setExam(exam);
        Term term=termRepository.findById(markDto.getTermId()).orElseThrow(
                ()->new RuntimeException("Term of this Id is not Found "+ markDto.getTermId()));
        mark.setTerm(term);

        Student student=studentRepository.findById(markDto.getStudentId()).orElseThrow(
                ()->new RuntimeException("Student of this Id is not Found "+ markDto.getStudentId()));
        mark.setStudent(student);
        MyYear myYear=yearRepository.findById(markDto.getMyYearId()).orElseThrow(
                ()->new RuntimeException("Year of this Id is not Found "+ markDto.getMyYearId()));
        mark.setMyYear(myYear);
        Mark mark1=markRepository.save(mark);
        return MarkMapper.mapToMarkDto(mark1);
    }

    @Override
    public MarkDto findMarkById(Long id) {
        Mark mark=markRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Marks of this Id is not Found "+id));
        return MarkMapper.mapToMarkDto(mark);
    }

    @Override
    public List<MarkDto> findAllMark() {
        List<Mark> marks=markRepository.findAll();
        return marks.stream().map(MarkMapper::mapToMarkDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMarkById(Long id) {
        Mark mark=markRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Marks of this Id is not Found "+id));
        markRepository.deleteById(id);
    }

    @Override
    public MarkDto updateMark(MarkDto markDto, Long id) {
        Mark mark=markRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Mark of this Id is not found "+id));
        mark.setMark(markDto.getMark());
        Subject subject=subjectRepository.findById(markDto.getSubjectId()).orElseThrow(
                ()->new RuntimeException("Subject of this Id is not Found "+ markDto.getSubjectId()));
        mark.setSubject(subject);
        Exam exam=examRepository.findById(markDto.getExamId()).orElseThrow(
                ()->new RuntimeException("Subject of this Id is not Found "+ markDto.getExamId()));
        mark.setExam(exam);
        Term term=termRepository.findById(markDto.getTermId()).orElseThrow(
                ()->new RuntimeException("Term of this Id is not Found "+ markDto.getTermId()));
        mark.setTerm(term);
        MyYear years=yearRepository.findById(markDto.getMyYearId()).orElseThrow(
                ()->new RuntimeException("Year of this Id is not Found "+ markDto.getMyYearId()));
        mark.setMyYear(years);
        Student student=studentRepository.findById(markDto.getStudentId()).orElseThrow(
                ()->new RuntimeException("Student of this Id is not Found "+ markDto.getStudentId()));
        mark.setStudent(student);
        Mark mark1=markRepository.save(mark);
        return MarkMapper.mapToMarkDto(mark1);
    }
}
