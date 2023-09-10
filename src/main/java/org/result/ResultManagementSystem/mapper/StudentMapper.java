package org.result.ResultManagementSystem.mapper;

import org.result.ResultManagementSystem.dto.StudentDto;
import org.result.ResultManagementSystem.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getMiddleName(),
                student.getLastName(),
                student.getGender(),
                student.getPhoneNumber(),
                student.getDateOfBirth(),
                student.getLevels().getId()
        );
    }

    public  static  Student mapToStudent(StudentDto studentDto){
        Student student= new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setMiddleName(studentDto.getMiddleName());
        student.setLastName(studentDto.getLastName());
        student.setGender(studentDto.getGender());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        return  student;
    }
}
