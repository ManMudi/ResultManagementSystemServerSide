package org.result.ResultManagementSystem.mapper;

import org.result.ResultManagementSystem.dto.SchoolDto;
import org.result.ResultManagementSystem.entity.School;

public class SchoolMapper {

    public static SchoolDto mapToSchoolDto(School school){

        SchoolDto schoolDto=new SchoolDto();
        schoolDto.setId(school.getId());
        schoolDto.setName(school.getName());
        schoolDto.setEmail(school.getEmail());
        schoolDto.setAddress(school.getAddress());
        schoolDto.setPhone(school.getPhone());
        return schoolDto;
    }

    public static School mapToSchool(SchoolDto schoolDto){

       School school=new School();
       school.setId(schoolDto.getId());
       school.setName(schoolDto.getName());
       school.setAddress(schoolDto.getAddress());
       school.setEmail(schoolDto.getEmail());
       school.setPhone(schoolDto.getPhone());
        return school;
    }
}
