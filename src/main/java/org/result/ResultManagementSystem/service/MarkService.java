package org.result.ResultManagementSystem.service;

import org.result.ResultManagementSystem.dto.MarkDto;
import org.result.ResultManagementSystem.entity.MarksProjection;
import org.result.ResultManagementSystem.response.MarksRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface MarkService {

    MarkDto createMark(MarkDto markDto);
    MarkDto findMarkById(Long id);
    List<MarkDto> findAllMark();
    void deleteMarkById(Long id);
    MarkDto updateMark(MarkDto markDto,Long id);

    List<MarksProjection> fetchMark();
    List<MarkDto> fetchMarkBySubject(Long id);
    List<MarkDto> fetchAll(String subId,Long eId,Long tId,Long yearId);
    int countAll(String subId,Long eId,Long tId,Long yearId);

    Page<MarksRes> getAllMarks(Pageable pageable, Long examId, Long yearId, Long studentId, String subjectId, Long termId, String schoolId);

}
