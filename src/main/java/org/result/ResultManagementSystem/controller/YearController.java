package org.result.ResultManagementSystem.controller;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.YearDto;
import org.result.ResultManagementSystem.service.YearService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequestMapping("/years")
@RestController
@AllArgsConstructor

public class YearController {
    private YearService yearService;
  //CREATE YEAR IN REST API
    @PostMapping
    public ResponseEntity<YearDto> responseEntity(@RequestBody YearDto yearDto){
        YearDto yearDto1=yearService.createYear(yearDto);
        return new ResponseEntity<>(yearDto1, HttpStatus.CREATED);
    }

    //FIND  YEAR BY FIND BY REST API
    @GetMapping("{yearId}")
    public ResponseEntity<YearDto> responseEntity(@PathVariable("yearId") Long id){
        YearDto yearDto=yearService.findById(id);
        return new ResponseEntity<>(yearDto,HttpStatus.OK);
    }
    //GET ALL REST API
    @GetMapping
    public ResponseEntity<List<YearDto>> responseEntity(){
        List<YearDto> yearDto=yearService.findAll();
        return new ResponseEntity<>(yearDto,HttpStatus.OK);
    }

    //UPDATE REST API
    @PutMapping("{yearId}")
    public  ResponseEntity<YearDto> yearDtoResponseEntity(@PathVariable("yearId") Long id,@RequestBody YearDto yearDto){
        YearDto yearDto1=yearService.updateYear(id,yearDto);
        return new ResponseEntity<>(yearDto1,HttpStatus.OK);
    }

    //DELETE REST API
    @DeleteMapping("{yearId}")
    public ResponseEntity<String> stringResponseEntity(@PathVariable("yearId") Long id){
        yearService.deleteById(id);
        return new ResponseEntity<>("Year Deleted Successfully !",HttpStatus.OK);
    }

}
