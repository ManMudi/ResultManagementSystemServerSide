package org.result.ResultManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "terms")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TermEnum name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "term")
    private List<Mark> marks=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "year_id",referencedColumnName = "id")
    private Year year;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "term")
    private List<Exam> exams=new ArrayList<>();
}
