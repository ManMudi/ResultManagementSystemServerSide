package org.result.ResultManagementSystem.service;

import org.result.ResultManagementSystem.dto.LevelDto;

import java.util.List;

public interface LevelService {
    LevelDto createLevel(LevelDto levelDto);

    LevelDto getLevelById(Long id);

    List<LevelDto> getAllLevel();

    LevelDto updateLevel(LevelDto levelDto,Long id);

    void deleteLevel(Long levelId);
}
