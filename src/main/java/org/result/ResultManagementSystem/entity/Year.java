package org.result.ResultManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "years")
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate year;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "year")
    private List<Level> level=new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "year")
    private List<Exam> exams=new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "year")
    private List<Term> terms=new ArrayList<>();
}
