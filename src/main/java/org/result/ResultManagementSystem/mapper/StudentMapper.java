package org.result.ResultManagementSystem.mapper;

import org.result.ResultManagementSystem.dto.StudentDto;
import org.result.ResultManagementSystem.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){

        StudentDto studentDto=new StudentDto();
               studentDto.setId(student.getId());
                studentDto.setFirstName(student.getFirstName());
                studentDto.setMiddleName(student.getMiddleName());
                studentDto.setLastName(student.getLastName());
                studentDto.setGender(student.getGender());
                studentDto.setPhoneNumber(student.getPhoneNumber());
                studentDto.setDateOfBirth(student.getDateOfBirth());
                studentDto.setLevelId(student.getLevels().getId());
                return studentDto;

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
