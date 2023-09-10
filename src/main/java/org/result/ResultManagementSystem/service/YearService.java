package org.result.ResultManagementSystem.service;

import org.result.ResultManagementSystem.dto.YearDto;

import java.util.List;

public interface YearService {

    YearDto createYear(YearDto yearDto);
    YearDto findById(Long id);
    List<YearDto> findAll();
    YearDto updateYear(Long id,YearDto yearDto);
    void deleteById(Long id);

}
