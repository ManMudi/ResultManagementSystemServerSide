package org.result.ResultManagementSystem.mapper;


import org.result.ResultManagementSystem.dto.YearDto;
import org.result.ResultManagementSystem.entity.MyYear;

public class YearMapper {

    public static YearDto mapToYearDto(MyYear year){

        return new YearDto(
                year.getId(),
                year.getYearValue()
        );
    }

    public  static MyYear mapToYear(YearDto yearDto){
        return new MyYear(
                yearDto.getId(),
                yearDto.getYearValue()
        );
    }
}
