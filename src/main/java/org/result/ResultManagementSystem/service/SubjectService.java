package org.result.ResultManagementSystem.service;

import org.result.ResultManagementSystem.dto.SubjectDto;

import java.util.List;

public interface SubjectService {

    SubjectDto createSubject (SubjectDto subjectDto);
    SubjectDto findSubjectById(Long id);
    List<SubjectDto> getAllSubjects();
    SubjectDto updateSubject(SubjectDto subjectDto,Long id);
    void deleteSubject(Long id);
}
