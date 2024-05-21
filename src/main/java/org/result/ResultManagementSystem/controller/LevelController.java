package org.result.ResultManagementSystem.controller;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.LevelDto;
import org.result.ResultManagementSystem.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Controller
@AllArgsConstructor
@RequestMapping("/levels")
public class LevelController {

    private LevelService levelService;

    //Build Add class REST API
    @PostMapping
    public ResponseEntity<LevelDto> responseEntity(@RequestBody LevelDto levelDto){
        LevelDto levelDto1=levelService.createLevel(levelDto);
        return new ResponseEntity<>(levelDto1, HttpStatus.CREATED);

    }

    //get Level By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<LevelDto> responseEntity(@PathVariable("id") Long levelId){
        LevelDto levelDto=levelService.getLevelById(levelId);
        return new ResponseEntity<>(levelDto,HttpStatus.OK);
    }
     @GetMapping
    public  ResponseEntity<List<LevelDto>> responseEntity(){
        List<LevelDto> levelDtos=levelService.getAllLevel();
        return new ResponseEntity<>(levelDtos,HttpStatus.OK);
    }
    @PutMapping("{levelId}")
    public  ResponseEntity<LevelDto> levelDtoResponseEntity(@RequestBody LevelDto levelDto,@PathVariable("levelId") Long id){
        LevelDto levelDto1=levelService.updateLevel(levelDto,id);
        return new ResponseEntity<>(levelDto1,HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLevel(@PathVariable("id") Long levelId){
        levelService.deleteLevel(levelId);
        return new  ResponseEntity<>("Class Deleted Successfully !",HttpStatus.OK);
    }

}
