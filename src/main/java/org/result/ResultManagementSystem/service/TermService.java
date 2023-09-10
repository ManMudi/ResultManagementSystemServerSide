package org.result.ResultManagementSystem.service;

import org.result.ResultManagementSystem.dto.TermDto;

import java.util.List;

public interface TermService {
    TermDto createTerm(TermDto termDto);
    TermDto findTermById(Long id);
    List<TermDto> getAllTerm();
    TermDto updateTerm(TermDto termDto,Long id);
    void deleteTermById(Long id);
}
