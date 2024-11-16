package org.result.ResultManagementSystem.controller;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.MarkDto;
import org.result.ResultManagementSystem.entity.MarksProjection;
import org.result.ResultManagementSystem.response.MarksRes;
import org.result.ResultManagementSystem.service.MarkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/mark-ordinary")
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
    @GetMapping("all")
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
    @GetMapping("fetch")
    public ResponseEntity<List<MarksProjection>> fetchMark(){
       List<MarksProjection> mark = markService.fetchMark();
       return new ResponseEntity<>(mark,HttpStatus.OK);
    }

    @GetMapping("fetch/{id}")
    public ResponseEntity<List<MarkDto>> fetchSubject(@PathVariable Long id){
        List<MarkDto> markDto = markService.fetchMarkBySubject(id);
        return new ResponseEntity<>(markDto,HttpStatus.OK);
    }
    @GetMapping("all/{subId}/{eId}/{tId}/{yearId}")
    public ResponseEntity<List<MarkDto>> fetchMarkDto(
            @PathVariable String subId,@PathVariable Long eId,@PathVariable Long tId,@PathVariable Long yearId){
        List<MarkDto> markDto=markService.fetchAll(subId,eId,tId,yearId);
        return new ResponseEntity<>(markDto,HttpStatus.OK);
    }

    @GetMapping("count/{subId}/{eId}/{tId}/{yearId}")
    public ResponseEntity<Integer> count(
            @PathVariable String subId,@PathVariable Long eId,@PathVariable Long tId,@PathVariable Long yearId){
        int countAll=markService.countAll(subId,eId,tId,yearId);
        return new ResponseEntity<>(countAll,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<MarksRes>> getAllMarks(
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "size",defaultValue = "10") int size,
            @RequestParam(name = "examId",required = false) Long examId,
            @RequestParam(name = "termId",required = false) Long termId,
            @RequestParam(name = "subjectId",required = false) String subjectId,
            @RequestParam(name = "yearId",required = false) Long yearId,
            @RequestParam(name = "schoolId",required = false) String schoolId,
            @RequestParam(name = "studentId",required = false) Long studentId,
            @RequestParam(name = "sort",defaultValue = "mark") String sort,
            @RequestParam(name = "order",defaultValue = "asc") String order
            ){
        Sort.Direction direction=order.equalsIgnoreCase("desc") ? Sort.Direction.DESC:Sort.Direction.ASC;
        Sort sorting=Sort.by(direction,sort);
        Pageable pageable=PageRequest.of(page,size,sorting);
        Page<MarksRes> markRes=markService.getAllMarks(pageable,examId,yearId,studentId,subjectId,termId,schoolId);
        return new ResponseEntity<>(markRes,HttpStatus.OK);
    }
}
