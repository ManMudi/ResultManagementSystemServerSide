package org.result.ResultManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDto {

    private String id;
    private String name;
    private String address;
    private String email;
    private String phone;

}
