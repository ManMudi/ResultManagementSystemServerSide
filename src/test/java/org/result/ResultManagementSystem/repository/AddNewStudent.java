package org.result.ResultManagementSystem.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.result.ResultManagementSystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AddNewStudent {
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private  StudentRepository studentRepository;
    @Autowired
    private  YearRepository yearRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @DisplayName("Student")
    @Test
    public void addStudent(){

        Level level=new Level();
        level.setLevel(LevelEnum.FORM_TWO);

        Student student1=new Student();
        student1.setFirstName("Mohamed");
        student1.setMiddleName("Yussuf");
        student1.setLastName("Ahmed");
        student1.setGender(Gender.MALE);
        student1.setPhoneNumber("0778939544");
        student1.setDateOfBirth(LocalDate.now());
        student1.setLevel(level);

        Student student2=new Student();
        student2.setFirstName("Zahra");
        student2.setMiddleName("Ismail");
        student2.setLastName("Ziad");
        student2.setGender(Gender.FEMALE);
        student2.setPhoneNumber("0778939544");
        student2.setDateOfBirth(LocalDate.now());
        student2.setLevel(level);


        Year year=new Year();
        year.setYear(LocalDate.now());
        year.setLevel(List.of(level));

        Mark mark1=new Mark();
        mark1.setMark(100);

        Mark mark2=new Mark();
        mark2.setMark(500);

        Mark mark3=new Mark();
        mark3.setMark(80);

        Subject subject=new Subject();
        subject.setName("Mathematics");

        subject.setMarks(List.of(mark1,mark2,mark3));
        mark1.setSubject(subject);
        mark2.setSubject(subject);
        mark3.setSubject(subject);


        student1.setMarks(List.of(mark1,mark3));
        student2.setMarks(List.of(mark2));
        mark1.setStudent(student1);
        mark2.setStudent(student2);
        mark3.setStudent(student1);

        level.setMarks(List.of(mark1,mark2,mark3));
        mark1.setLevel(level);
        mark2.setLevel(level);
        mark3.setLevel(level);

        Exam exam=new Exam();
        exam.setName("Terminal");

        exam.setMarks(List.of(mark1,mark2,mark3));
        mark1.setExam(exam);
        mark2.setExam(exam);
        mark3.setExam(exam);

        exam.setYear(year);
        year.setExams(List.of(exam));

        Term term=new Term();
        term.setName(TermEnum.FIRST_TERM);

        exam.setTerm(term);
        term.setExams(List.of(exam));

        term.setMarks(List.of(mark1,mark2,mark3));
        mark1.setTerm(term);
        mark2.setTerm(term);
        mark3.setTerm(term);

        term.setYear(year);
        year.setTerms(List.of(term));

        level.setStudents(List.of(student1,student2));
        level.setYear(year);

        yearRepository.save(year);

    }
    @Test
    public void addUserRole(){

        Users user1=new Users();
        user1.setName("Hamad");

        Users user2=new Users();
        user2.setName("Ibrahim");

        Users user3=new Users();
        user3.setName("Sultan");

        Role role1=new Role();
        role1.setRole(RoleEnum.USER);

        Role role2=new Role();
        role2.setRole(RoleEnum.USER);

        Role role3=new Role();
        role3.setRole(RoleEnum.ADMIN);

        role1.getUsers().add(user1);role2.getUsers().add(user2);role3.getUsers().add(user3);
        user1.getRole().add(role1);user2.getRole().add(role2);user3.getRole().add(role3);

      userRepository.saveAll(List.of(user1,user2,user3));


    }
    @Test
    public  void findAllStudents(){

        List<Student> studentList=studentRepository.findAll();
        studentList.forEach(student -> {
            System.out.println(student.getLevel());
        });

    }
    @Test
    public void findAllClass(){
        List<Level> levels=levelRepository.findAll();
        levels.forEach(System.out::println);
    }

}