package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.StudentDto;
import org.result.ResultManagementSystem.entity.Levels;
import org.result.ResultManagementSystem.entity.Student;
import org.result.ResultManagementSystem.exception.ResourceNotFoundException;
import org.result.ResultManagementSystem.mapper.StudentMapper;
import org.result.ResultManagementSystem.repository.LevelRepository;
import org.result.ResultManagementSystem.repository.StudentRepository;
import org.result.ResultManagementSystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentImpl implements StudentService {

    private StudentRepository studentRepository;
    private LevelRepository levelRepository;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student= StudentMapper.mapToStudent(studentDto);
        Levels levels=levelRepository.findById(studentDto.getLevelId()).orElseThrow(
                ()->new ResourceNotFoundException("Class is not exist with given id : "+ studentDto.getLevelId()));
        student.setLevels(levels);
        Student savedStudent=studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student=studentRepository.findById(studentId).orElseThrow(
                ()->new ResourceNotFoundException("Student is not exist with given id : "+ studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> studentList=studentRepository.findAll();
        return studentList.stream().map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(StudentDto updatedStudent, Long studentId) {
        Student student=studentRepository.findById(studentId).orElseThrow(
                ()->new ResourceNotFoundException("Student is not exist with given id : "+ studentId));
        student.setFirstName(updatedStudent.getFirstName());
        student.setMiddleName(updatedStudent.getMiddleName());
        student.setLastName(updatedStudent.getLastName());
        student.setGender(updatedStudent.getGender());
        student.setDateOfBirth(updatedStudent.getDateOfBirth());
        student.setPhoneNumber(updatedStudent.getPhoneNumber());
        Levels levels=levelRepository.findById(updatedStudent.getLevelId()).orElseThrow(
                ()->new ResourceNotFoundException("Student is not exist with given id : "+ updatedStudent.getLevelId()));
        student.setLevels(levels);
        studentRepository.save(student);
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student=studentRepository.findById(studentId).orElseThrow(
                ()->new ResourceNotFoundException("Student is not exist with given id : "+ studentId));
        studentRepository.deleteById(studentId);
    }


}

















