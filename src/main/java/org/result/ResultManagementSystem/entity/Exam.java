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
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "exam")
    private List<Mark> marks=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "term_id",referencedColumnName = "id")
    private Term term;
    @ManyToOne
    @JoinColumn(name = "year_id",referencedColumnName = "id")
    private Year year;

}
