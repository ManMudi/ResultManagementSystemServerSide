package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.SubjectDto;
import org.result.ResultManagementSystem.entity.Subject;
import org.result.ResultManagementSystem.exception.ResourceNotFoundException;
import org.result.ResultManagementSystem.mapper.SubjectMapper;
import org.result.ResultManagementSystem.repository.SubjectRepository;
import org.result.ResultManagementSystem.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectImple implements SubjectService {

    private SubjectRepository subjectRepository;
    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        Subject subject= SubjectMapper.mapToSubject(subjectDto);
        Subject savedSubject=subjectRepository.save(subject);
        return SubjectMapper.mapToSubjectDto(savedSubject);
    }

    @Override
    public SubjectDto findSubjectById(String id) {
        Subject subject=subjectRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Subject is not exist with given id : "+ id));
        return SubjectMapper.mapToSubjectDto(subject);
    }

    @Override
    public List<SubjectDto> getAllSubjects() {
        List<Subject> subjects=subjectRepository.findAll();
        return subjects.stream().map( (subject)-> SubjectMapper.mapToSubjectDto(subject))
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDto updateSubject(SubjectDto subjectDto, String id) {
        Subject subject=subjectRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Subject is not exist with given id : "+ id));
        subject.setSubject(subjectDto.getSubject());
        subject.setDescription(subjectDto.getDescription());
        Subject subject1=subjectRepository.save(subject);
        return SubjectMapper.mapToSubjectDto(subject1);
    }

    @Override
    public void deleteSubject(String id) {
        Subject subject=subjectRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subject is not exist with given id : "+ id));
        subjectRepository.deleteById(id);
    }
}
