package org.result.ResultManagementSystem.controller;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.SubjectDto;
import org.result.ResultManagementSystem.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequestMapping("/subjects")
@RestController
@AllArgsConstructor
public class SubjectController {
    private SubjectService subjectService;
    //BUILD REST API
    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto){
       SubjectDto subjectDto1 = subjectService.createSubject(subjectDto);
        return new ResponseEntity<>(subjectDto1, HttpStatus.CREATED);
    }
    //GET BY ID REST API
    @GetMapping("{id}")
    public ResponseEntity<SubjectDto> findSubjectById(@PathVariable("id") String subjectId){
        SubjectDto subjectDto=subjectService.findSubjectById(subjectId);
        return new ResponseEntity<>(subjectDto,HttpStatus.OK);
    }
    //GET ALL REST API
    @GetMapping
    public  ResponseEntity<List<SubjectDto>> getAllSubject(){
        List<SubjectDto> subjectDtos=subjectService.getAllSubjects();
        return new ResponseEntity<>(subjectDtos,HttpStatus.OK);
    }
    //UPDATE REST API
    @PutMapping("{id}")
    public  ResponseEntity<SubjectDto> updateSubject(@RequestBody SubjectDto subjectDto,@PathVariable("id") String subjectId){
        SubjectDto subjectDto1=subjectService.updateSubject(subjectDto,subjectId);
        return new ResponseEntity<>(subjectDto1,HttpStatus.OK);
    }
    //DELETE REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable("id") String subjectId){
        subjectService.deleteSubject(subjectId);
        return new ResponseEntity<>("Subject Deleted Successfully !",HttpStatus.OK);
    }
}
