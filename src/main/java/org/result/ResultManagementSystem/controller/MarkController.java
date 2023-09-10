package org.result.ResultManagementSystem.controller;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.MarkDto;
import org.result.ResultManagementSystem.service.MarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/marks")
public class MarkController {

    private MarkService markService;
    @PostMapping
    public ResponseEntity<MarkDto> createMark(@RequestBody MarkDto markDto){
        MarkDto markDto1=markService.createMark(markDto);
        return new ResponseEntity<>(markDto1, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<MarkDto> getMarkById(@PathVariable("id") Long MarkId){
        MarkDto markDto=markService.findMarkById(MarkId);
        return new ResponseEntity<>(markDto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<MarkDto>> getAllMark(){
        List<MarkDto> markDto=markService.findAllMark();
        return new ResponseEntity<>(markDto,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMarkById(@PathVariable("id") Long markId){
        markService.deleteMarkById(markId);
        return new ResponseEntity<>("Mark Deleted Successfully !",HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<MarkDto> updateMark(@RequestBody MarkDto markDto,@PathVariable("id") Long markId){
        MarkDto markDto1=markService.updateMark(markDto,markId);
        return new ResponseEntity<>(markDto1,HttpStatus.OK);
    }
}
