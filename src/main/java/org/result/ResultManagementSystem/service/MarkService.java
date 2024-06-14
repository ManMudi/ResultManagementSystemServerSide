package org.result.ResultManagementSystem.service;

import org.result.ResultManagementSystem.dto.MarkDto;

import java.util.List;

public interface MarkService {

    MarkDto createMark(MarkDto markDto);
    MarkDto findMarkById(Long id);
    List<MarkDto> findAllMark();
    void deleteMarkById(Long id);
    MarkDto updateMark(MarkDto markDto,Long id);
}
