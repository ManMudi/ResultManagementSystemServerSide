package org.result.ResultManagementSystem.service;

import org.result.ResultManagementSystem.dto.SchoolDto;

import java.util.List;


public interface SchoolService {

    SchoolDto createSchool( SchoolDto schoolDto);
    SchoolDto updateSchool(String id,SchoolDto schoolDto);
    SchoolDto getSchoolById(String id);
    List<SchoolDto> getAllSchool();
    void deleteSchoolById(String id);
}
