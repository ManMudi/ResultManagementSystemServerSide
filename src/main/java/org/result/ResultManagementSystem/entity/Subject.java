package org.result.ResultManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "subjects")
public class Subject {
    @Id
    private String id;
    private String subject;
    private String description;

}
