package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.SchoolDto;
import org.result.ResultManagementSystem.entity.School;
import org.result.ResultManagementSystem.exception.ResourceNotFoundException;
import org.result.ResultManagementSystem.mapper.SchoolMapper;
import org.result.ResultManagementSystem.mapper.StudentMapper;
import org.result.ResultManagementSystem.mapper.TermMapper;
import org.result.ResultManagementSystem.repository.SchoolRepository;
import org.result.ResultManagementSystem.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SchoolImpl implements SchoolService {

    private SchoolRepository schoolRepository;

    @Override
    public SchoolDto createSchool(SchoolDto schoolDto) {
        School school= SchoolMapper.mapToSchool(schoolDto);
        School school1 = schoolRepository.save(school);
        return SchoolMapper.mapToSchoolDto(school1);
    }

    @Override
    public SchoolDto updateSchool( String id,SchoolDto schoolDto) {
       School school=schoolRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Student is not exist with given id : "+ id));
       school.setName(schoolDto.getName());
       school.setEmail(schoolDto.getEmail());
       school.setAddress(schoolDto.getAddress());
       school.setPhone(schoolDto.getPhone());
       schoolRepository.save(school);
        return SchoolMapper.mapToSchoolDto(school);
    }

    @Override
    public SchoolDto getSchoolById(String id) {
        School school=schoolRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Student is not exist with given id : "+ id));
        return SchoolMapper.mapToSchoolDto(school);
    }

    @Override
    public List<SchoolDto> getAllSchool() {
       List<School> school= schoolRepository.findAll();
        return school.stream().map(SchoolMapper::mapToSchoolDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSchoolById(String id) {
        School school=schoolRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Student is not exist with given id : "+ id));
        schoolRepository.deleteById(id);
    }


}
