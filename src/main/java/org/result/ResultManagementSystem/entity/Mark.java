package org.result.ResultManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal mark;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Subject subject;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Exam exam;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Term term;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Years years;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Student student;


}
