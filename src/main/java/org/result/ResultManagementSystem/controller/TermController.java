package org.result.ResultManagementSystem.controller;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.TermDto;
import org.result.ResultManagementSystem.entity.Term;
import org.result.ResultManagementSystem.service.TermService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/terms")
public class TermController {
    private TermService termService;
    //REST API TO CREATE TERM
    @PostMapping
    public ResponseEntity<TermDto> createTerm(@RequestBody TermDto termDto){
       TermDto termDto1=termService.createTerm(termDto);
       return new ResponseEntity<>(termDto1, HttpStatus.CREATED);
    }

    //REST API TO GET TERMS BY ID
    @GetMapping("{id}")
    public  ResponseEntity<TermDto> getTermById(@PathVariable("id") Long termId){
        TermDto termDto=termService.findTermById(termId);
        return new ResponseEntity<>(termDto,HttpStatus.OK);
    }
    //REST API TO GET ALL TERMS
    @GetMapping
    public ResponseEntity<List<TermDto>> getAllTerm(){
        List<TermDto> termDtos=termService.getAllTerm();
        return new ResponseEntity<>(termDtos,HttpStatus.OK);
    }
    //UPDATE REST API
    @PutMapping("{id}")
    public ResponseEntity<TermDto> updateTerm(@RequestBody TermDto termDto,@PathVariable("id") Long termId){
        TermDto termDto1=termService.updateTerm(termDto,termId);
        return new ResponseEntity<>(termDto1,HttpStatus.OK);
    }
    //DELETE REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long termId){
      termService.deleteTermById(termId);
      return new ResponseEntity<>("Term Deleted Successfully !",HttpStatus.OK);
    }
}
