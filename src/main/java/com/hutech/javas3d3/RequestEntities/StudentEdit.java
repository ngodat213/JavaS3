package com.hutech.javas3d3.RequestEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEdit {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
}
