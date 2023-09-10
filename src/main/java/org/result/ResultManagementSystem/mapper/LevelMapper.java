package org.result.ResultManagementSystem.mapper;

import org.result.ResultManagementSystem.dto.LevelDto;
import org.result.ResultManagementSystem.entity.Levels;

public class LevelMapper {

    public static LevelDto  mapToLevelDto(Levels levels){

        return  new LevelDto (
                levels.getId(),
                levels.getLevelName()
        );
    }

    public  static Levels mapToLevel(LevelDto levelDto){
        return new Levels(
                levelDto.getId(),
                levelDto.getLevelName()
        );
    }
}
