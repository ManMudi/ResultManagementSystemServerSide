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
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private  String middleName;
    private String lastName;
    private Gender gender;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id",referencedColumnName = "id")
    private Level level;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
    private List<Mark> marks=new ArrayList<>();

}
