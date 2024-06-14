package org.result.ResultManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


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
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Levels level;
}
