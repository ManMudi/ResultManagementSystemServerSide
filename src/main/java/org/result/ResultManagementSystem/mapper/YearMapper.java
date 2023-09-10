package org.result.ResultManagementSystem.mapper;


import org.result.ResultManagementSystem.dto.YearDto;
import org.result.ResultManagementSystem.entity.Years;

public class YearMapper {

    public static YearDto mapToYearDto(Years year){

        return new YearDto(
                year.getId(),
                year.getYearValue()
        );
    }

    public  static Years mapToYear(YearDto yearDto){
        return new Years(
                yearDto.getId(),
                yearDto.getYearValue()
        );
    }
}
