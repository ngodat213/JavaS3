package com.hutech.javas3d3.Controllers;

import com.hutech.javas3d3.Entities.Classroom;
import com.hutech.javas3d3.Entities.Student;
import com.hutech.javas3d3.RequestEntities.StudentCreate;
import com.hutech.javas3d3.RequestEntities.StudentEdit;
import com.hutech.javas3d3.Services.ClassroomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {
    @Autowired
    private ClassroomServices classroomServices;
    @GetMapping("")
    public String getClassrooms(Model model) {
        List<Classroom> classrooms = classroomServices.getAllClassrooms();
        model.addAttribute("classrooms", classrooms);
        return "Classroom/getAll";
    }

    @GetMapping("/new")
    public String AddClassroom(Model model) {
        model.addAttribute("classroom", new Classroom());
        return "Classroom/add";
    }

    @PostMapping("/save")
    public String saveClassroom(Classroom classroom) {
        classroomServices.addClassroom(classroom);
        return "redirect:/classrooms";
    }

    @GetMapping("/edit/{id}")
    public String editClassroom(@PathVariable String id, Model model){
        Classroom classroom = classroomServices.getClassroomById(id);
        model.addAttribute("classroom", classroom);
        return "Classroom/edit";
    }

    @GetMapping("/view/{id}")
    public String viewClassroom(@PathVariable String id, Model model){
        Classroom classroom = classroomServices.getClassroomById(id);
        model.addAttribute("classroom", classroom);
        return "Classroom/view";
    }

    @PostMapping("/saveedit")
    public String saveClassroomEdit(Classroom classroom){
        classroomServices.UpdateClassroom(classroom);
        return "redirect:/classrooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteClassroom(@PathVariable String id){
        classroomServices.DeleteClassroom(id);
        return "redirect:/classrooms";
    }
}
