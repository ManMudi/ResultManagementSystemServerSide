package org.result.ResultManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

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
    private MyYear myYear;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Student student;


}
