package org.result.ResultManagementSystem.mapper;

import org.result.ResultManagementSystem.dto.MarkDto;
import org.result.ResultManagementSystem.entity.Mark;

public class MarkMapper {

    public static MarkDto mapToMarkDto(Mark mark){

                MarkDto markDto=new MarkDto();
                markDto.setId(mark.getId());
                markDto.setStudentId(mark.getId());
                markDto.setMark(mark.getMark());
                markDto.setExamId(mark.getExam().getId());
                markDto.setTermId(mark.getTerm().getId());
                markDto.setMyYearId(mark.getMyYear().getId());
                markDto.setSubjectId(mark.getSubject().getId());
                return markDto;

    }

    public  static Mark mapToMark(MarkDto markDto){
       Mark mark=new Mark();
       mark.setId(markDto.getId());
       mark.setMark(markDto.getMark());
       return mark;
    }
}
