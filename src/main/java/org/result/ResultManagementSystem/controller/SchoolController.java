package org.result.ResultManagementSystem.controller;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.SchoolDto;
import org.result.ResultManagementSystem.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("schools")
public class SchoolController {

    private SchoolService schoolService;

    @PostMapping
    public ResponseEntity<SchoolDto> createSchool(@RequestBody SchoolDto schoolDto){
        SchoolDto schoolDto1=schoolService.createSchool(schoolDto);
        return ResponseEntity.ok(schoolDto1);
    }
    @GetMapping("{id}")
    public ResponseEntity<SchoolDto> getSchoolById(@PathVariable String id){
        SchoolDto schoolDto=schoolService.getSchoolById(id);
        return ResponseEntity.ok(schoolDto);
    }
    @GetMapping
    public ResponseEntity<List<SchoolDto>> getAllSchool(){
        List<SchoolDto> allSchool=schoolService.getAllSchool();
        return ResponseEntity.ok(allSchool);
   }
   @PutMapping("{id}")
   public ResponseEntity<SchoolDto> updateSchool(@PathVariable String id,@RequestBody SchoolDto schoolDto){
        SchoolDto schoolDto1=schoolService.updateSchool(id,schoolDto);
        return  ResponseEntity.ok(schoolDto1);
   }

   @DeleteMapping("{id}")
   public ResponseEntity<String> deleteSchoolById(@PathVariable String id){
        schoolService.deleteSchoolById(id);
       return new ResponseEntity<>(id+"Student Deleted Successfully !",HttpStatus.OK);
   }

}
