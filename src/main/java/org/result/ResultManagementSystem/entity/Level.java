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
@Table(name = "classes")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LevelEnum level;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "level",fetch = FetchType.EAGER)
    private List<Student> students;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "year_id",referencedColumnName = "id")
    private Year year;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "level")
    private List<Mark> marks=new ArrayList<>();

}
