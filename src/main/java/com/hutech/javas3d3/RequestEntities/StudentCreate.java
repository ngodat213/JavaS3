package com.hutech.javas3d3.RequestEntities;

import com.hutech.javas3d3.Entities.Classroom;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreate {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;
    private Classroom classroom;
}
