package org.result.ResultManagementSystem.mapper;

import org.result.ResultManagementSystem.dto.MarkDto;
import org.result.ResultManagementSystem.entity.Mark;

public class MarkMapper {

    public static MarkDto mapToMarkDto(Mark mark){
        return new MarkDto(
                mark.getId(),
                mark.getMark(),
                mark.getSubject().getId(),
                mark.getExam().getId(),
                mark.getTerm().getId(),
                mark.getYears().getId(),
                mark.getSubject().getId()
        );
    }

    public  static Mark mapToMark(MarkDto markDto){
       Mark mark=new Mark();
       mark.setId(markDto.getId());
       mark.setMark(markDto.getMark());
       return mark;
    }
}
