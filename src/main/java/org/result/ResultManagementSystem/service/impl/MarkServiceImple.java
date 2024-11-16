package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.result.ResultManagementSystem.dto.MarkDto;
import org.result.ResultManagementSystem.entity.*;
import org.result.ResultManagementSystem.repository.*;
import org.result.ResultManagementSystem.response.MarksRes;
import org.result.ResultManagementSystem.service.MarkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
    private SchoolRepository schoolRepository;
    private ModelMapper modelMapper;

    @Override
    public MarkDto createMark(MarkDto markDto) {
        Mark mark= modelMapper.map(markDto, Mark.class);
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
        School school=schoolRepository.findById(markDto.getSchoolId()).orElseThrow(
                ()->new RuntimeException("School of this Id is not Found "+ markDto.getSchoolId()));
        mark.setSchool(school);
        Mark mark1=markRepository.save(mark);
        return modelMapper.map(mark1,MarkDto.class);
    }

    @Override
    public MarkDto findMarkById(Long id) {
        Mark mark=markRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Marks of this Id is not Found "+id));
        return modelMapper.map(mark,MarkDto.class);
    }

    @Override
    public List<MarkDto> findAllMark() {
        List<Mark> marks=markRepository.findAll();
        return marks.stream().map((mark)->modelMapper.map(mark,MarkDto.class))
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
        School school=schoolRepository.findById(markDto.getSchoolId()).orElseThrow(
                ()->new RuntimeException("School of this Id is not Found "+ markDto.getSchoolId()));
        mark.setSchool(school);
        Mark mark1=markRepository.save(mark);
        return modelMapper.map(mark1,MarkDto.class);
    }

    @Override
    public List<MarksProjection> fetchMark() {
        return markRepository.fetchMark();
    }

    @Override
    public List<MarkDto> fetchMarkBySubject(Long id) {
        List<Mark> marks=markRepository.fetchBySubject(id);
        return marks.stream().map((mark)->modelMapper.map(mark,MarkDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MarkDto> fetchAll(String subId,Long eId,Long tId,Long yearId) {
        List<Mark> marks=markRepository.fetchByAll(subId,eId,tId,yearId);
        return marks.stream().map((mark)->modelMapper.map(mark,MarkDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public int countAll(String subId, Long eId, Long tId, Long yearId) {
        return markRepository.countAll(subId,eId,tId,yearId);
    }

    @Override
    public Page<MarksRes> getAllMarks(Pageable pageable,Long examId,Long yearId,Long studentId,String subjectId,Long termId,String schoolId) {
        Specification<Mark> spec= Specification.where(null);{
            if(yearId!=null){
                spec=spec.and(((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("year").get("id"),yearId)));
            }
            if(studentId!=null){
                spec=spec.and(((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("student").get("id"),studentId)));
            }
            if(subjectId!=null){
                spec=spec.and(((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("subject").get("id"),subjectId)));
            }
            if(examId!=null){
                spec=spec.and(((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("exam").get("id"),examId)));
            }
            if(termId!=null){
                spec=spec.and(((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("term").get("id"),termId)));
            }
            if(schoolId!=null){
                spec=spec.and(((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("school").get("id"),schoolId)));
            }

        }
        return markRepository.findAll(spec,pageable).map(this::convertMarkToMarkResponse);
    }


    private MarksRes convertMarkToMarkResponse(Mark mark) {
        return MarksRes.builder()
                .id(mark.getId())
                .mark(mark.getMark())
                .markSubject(mark.getSubject().getSubject())
                .markTerm(mark.getTerm().getTerm())
                .markYear(mark.getMyYear().getYearValue())
                .markExam(mark.getExam().getExam())
                .markSchool(mark.getSchool().getName())
                .markStudent(mark.getStudent().getFirstName()+" "+mark.getStudent().getMiddleName()+" "+mark.getStudent().getLastName())
                .build();
    }


}
