package com.hutech.javas3d3.Services;

import com.hutech.javas3d3.Entities.Classroom;
import com.hutech.javas3d3.Entities.Student;
import com.hutech.javas3d3.Repositories.ClassroomRepository;
import com.hutech.javas3d3.RequestEntities.StudentEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClassroomServices {
    @Autowired
    private ClassroomRepository classroomRepository;

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public Classroom getClassroomById(String id){
        return classroomRepository.findById(id).orElseThrow(
                () -> {
                    throw  new RuntimeException("Khong tim thay ID");
                }
        );
    }

    public  void addClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    public Classroom UpdateClassroom(Classroom studentEdit){
        try{
            classroomRepository.save(studentEdit);
            return studentEdit;
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
    public void DeleteClassroom(String id){
        classroomRepository.deleteById(id);
    }
}
