package org.result.ResultManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private double mark;
    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "class_id",referencedColumnName = "id")
    private Level level;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private Subject subject;
    @ManyToOne()
    @JoinColumn(name = "exam_id",referencedColumnName = "id")
    private Exam exam;
    @ManyToOne()
    @JoinColumn(name = "term_id",referencedColumnName = "id")
    private Term term;

}
