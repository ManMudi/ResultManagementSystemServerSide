package org.result.ResultManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
public class MarksProjection  {
    private String firstName;
    private String middleName;
    private String lastName;
    private BigDecimal mark;
    private String exam;
    private String term;
    private String year;
    private String subject;
}
