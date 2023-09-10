package org.result.ResultManagementSystem.controller;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.ExamDto;
import org.result.ResultManagementSystem.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
@AllArgsConstructor

public class ExamController {
    private ExamService examService;
    @PostMapping
    public ResponseEntity<ExamDto> createExam(@RequestBody ExamDto examDto){
        ExamDto examDto1=examService.createExam(examDto);
        return new ResponseEntity<>(examDto1, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public  ResponseEntity<ExamDto> getExamById(@PathVariable("id") Long examId){
        ExamDto examDto=examService.getExamById(examId);
        return new ResponseEntity<>(examDto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ExamDto>> getAllExam(){
        List<ExamDto> examDtos=examService.getAllExam();
        return new ResponseEntity<>(examDtos,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<ExamDto> updateExam(@RequestBody ExamDto examDto,@PathVariable("id") Long examId){
        ExamDto examDto1=examService.updateExam(examDto,examId);
        return new ResponseEntity<>(examDto1,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExamById(@PathVariable("id") Long examId){
        examService.deleteExamById(examId);
        return new ResponseEntity<>("Exam Deleted Successfully !",HttpStatus.OK);
    }
}
