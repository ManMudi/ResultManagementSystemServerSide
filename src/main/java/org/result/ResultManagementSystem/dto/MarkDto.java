package org.result.ResultManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {

    private Long id;
    private BigDecimal mark;
    private String subjectId;
    private Long examId;
    private Long termId;
    private Long myYearId;
    private Long studentId;
    private String schoolId;

}
