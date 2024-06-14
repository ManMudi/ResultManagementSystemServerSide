package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.LevelDto;
import org.result.ResultManagementSystem.entity.Levels;
import org.result.ResultManagementSystem.exception.ResourceNotFoundException;
import org.result.ResultManagementSystem.mapper.LevelMapper;
import org.result.ResultManagementSystem.repository.LevelRepository;
import org.result.ResultManagementSystem.service.LevelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class LevelServiceImpl implements LevelService {
    private LevelRepository levelRepository;
    @Override
    public LevelDto createLevel(LevelDto levelDto) {
        Levels levels= LevelMapper.mapToLevel(levelDto);
        Levels savedLevel=levelRepository.save(levels);
        return LevelMapper.mapToLevelDto(savedLevel);
    }

    @Override
    public LevelDto getLevelById(Long id) {
        Levels levels=levelRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Class is not exist with given id : "+ id));;
        return LevelMapper.mapToLevelDto(levels);
    }

    @Override
    public List<LevelDto> getAllLevel() {
        List<Levels> levelsList=levelRepository.findAll();
        return levelsList.stream().map(LevelMapper::mapToLevelDto)
                .collect(Collectors.toList());
    }

    @Override
    public LevelDto updateLevel(LevelDto levelDto, Long id) {
        Levels levels=levelRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Class is not exist with given id : "+ id));
        levels.setLevelName(levelDto.getLevelName());
        levelRepository.save(levels);
        return LevelMapper.mapToLevelDto(levels);
    }

    @Override
    public void deleteLevel(Long levelId) {
        Levels levels=levelRepository.findById(levelId).orElseThrow(
                ()->new ResourceNotFoundException("Class is not exist with given id : "+ levelId));
        levelRepository.deleteById(levelId);
    }


}
