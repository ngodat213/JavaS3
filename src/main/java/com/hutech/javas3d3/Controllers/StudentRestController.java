package com.hutech.javas3d3.Controllers;

import com.hutech.javas3d3.Entities.Student;
import com.hutech.javas3d3.RequestEntities.StudentCreate;
import com.hutech.javas3d3.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    @Autowired
    private StudentServices studentServices;
    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentServices.getAllStudent();
    }
    @PostMapping("")
    public Student createStudent(@RequestBody StudentCreate studentCreate){
        return studentServices.createStudent(studentCreate);
    }
}
