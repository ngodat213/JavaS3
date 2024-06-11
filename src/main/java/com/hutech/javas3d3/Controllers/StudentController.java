package com.hutech.javas3d3.Controllers;

import com.hutech.javas3d3.Entities.Classroom;
import com.hutech.javas3d3.Entities.Student;
import com.hutech.javas3d3.RequestEntities.StudentCreate;
import com.hutech.javas3d3.RequestEntities.StudentEdit;
import com.hutech.javas3d3.Services.ClassroomServices;
import com.hutech.javas3d3.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServices studentServices;
    @Autowired
    private ClassroomServices classServices;
    @GetMapping("")
    public String getAllStudent(Model model){
        List<Student> students = studentServices.getAllStudent();
        model.addAttribute("students", students);
        return "Student/getAll";
    }
    @GetMapping("/new")
    public String addStudent(Model model){
        Student std = new Student();
        List<Classroom> classrooms = classServices.getAllClassrooms();
        model.addAttribute("student", std);
        model.addAttribute("classes", classrooms);
        return "Student/add";
    }

    @PostMapping("/save")
    public String saveStudent(StudentCreate studentCreate){
        studentServices.createStudent(studentCreate);
        return "redirect:/students";
    }
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable String id, Model model){
       Student student = studentServices.getStudentById(id);
       model.addAttribute("student", student);
       return "Student/edit";
    }

    @GetMapping("/view/{id}")
    public String viewStudent(@PathVariable String id, Model model){
        Student student = studentServices.getStudentById(id);
        model.addAttribute("student", student);
        return "Student/view";
    }

    @PostMapping("/saveedit")
    public String saveStudentEdit(StudentEdit studentEdit){
        studentServices.UpdateStudent(studentEdit);
        return "redirect:/students";
    }
    @GetMapping("/findemail")
    public String findemail(Model model){
        Student student = studentServices.findStudentByEmail("bm.toan@hutech.edu.vn");
        model.addAttribute("student", student);
        return "Student/edit";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        studentServices.DeleteStudent(id);
        return "redirect:/students";
    }

}
