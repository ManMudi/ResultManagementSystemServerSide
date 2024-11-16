package org.result.ResultManagementSystem.response;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarksRes {
    private Long id;
    private BigDecimal mark;
    private String markSubject;
    private String markExam;
    private String markTerm;
    private String markYear;
    private String markStudent;
    private String markSchool;
}
