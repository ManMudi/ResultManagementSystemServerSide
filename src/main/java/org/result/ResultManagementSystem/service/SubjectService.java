package org.result.ResultManagementSystem.service;

import org.result.ResultManagementSystem.dto.SubjectDto;

import java.util.List;

public interface SubjectService {

    SubjectDto createSubject (SubjectDto subjectDto);
    SubjectDto findSubjectById(String id);
    List<SubjectDto> getAllSubjects();
    SubjectDto updateSubject(SubjectDto subjectDto,String id);
    void deleteSubject(String id);
}
