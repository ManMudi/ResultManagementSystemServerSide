package org.result.ResultManagementSystem.mapper;

import org.result.ResultManagementSystem.dto.SubjectDto;
import org.result.ResultManagementSystem.entity.Subject;

public class SubjectMapper {

    public  static SubjectDto mapToSubjectDto(Subject subject){
        return new SubjectDto(
                subject.getId(),
                subject.getSubject().toUpperCase(),
                subject.getDescription()
        );
    }

    public  static Subject mapToSubject(SubjectDto subjectDto){
       Subject subject=new Subject();
       subject.setId(subjectDto.getId());
       subject.setSubject(subjectDto.getSubject());
       subject.setDescription(subjectDto.getDescription());
       return subject;
    }
}
