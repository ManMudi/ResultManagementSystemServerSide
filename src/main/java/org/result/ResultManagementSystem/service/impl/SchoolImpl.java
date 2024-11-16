package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.result.ResultManagementSystem.dto.SchoolDto;
import org.result.ResultManagementSystem.entity.School;
import org.result.ResultManagementSystem.exception.ResourceNotFoundException;
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
    private ModelMapper modelMapper;

    @Override
    public SchoolDto createSchool(SchoolDto schoolDto) {
        School school= modelMapper.map(schoolDto, School.class);
        School school1 = schoolRepository.save(school);
        return modelMapper.map(school1,SchoolDto.class);
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
        return modelMapper.map(school,SchoolDto.class);
    }

    @Override
    public SchoolDto getSchoolById(String id) {
        School school=schoolRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Student is not exist with given id : "+ id));
        return modelMapper.map(school,SchoolDto.class);
    }

    @Override
    public List<SchoolDto> getAllSchool() {
       List<School> school= schoolRepository.findAll();
        return school.stream().map((school1)->modelMapper.map(school1,SchoolDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSchoolById(String id) {
        School school=schoolRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Student is not exist with given id : "+ id));
        schoolRepository.deleteById(id);
    }


}
