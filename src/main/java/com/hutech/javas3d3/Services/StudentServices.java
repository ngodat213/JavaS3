package com.hutech.javas3d3.Services;

import com.hutech.javas3d3.Entities.Student;
import com.hutech.javas3d3.Repositories.StudentRepository;
import com.hutech.javas3d3.RequestEntities.StudentCreate;
import com.hutech.javas3d3.RequestEntities.StudentEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentById(String id){
        return studentRepository.findById(id).orElseThrow(
                () -> {
                    throw  new RuntimeException("Khong tim thay ID");
                }
        );
    }
    public Student createStudent(StudentCreate studentCreate){
       try{
           Student student = new Student();
           student.setFirstName(studentCreate.getFirstName());
           student.setLastName(studentCreate.getLastName());
           student.setEmail(studentCreate.getEmail());
           student.setPassword(studentCreate.getPassword());//yyyy-MM-dd
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           student.setDateOfBirth(dateFormat.parse(studentCreate.getDateOfBirth()));
           student.setAge((new Date()).getYear()-student.getDateOfBirth().getYear());
           student.setClassroom(studentCreate.getClassroom());
           studentRepository.save(student);
           return student;
       }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
       }
    }
    public Student UpdateStudent(StudentEdit studentEdit){
        try{
           Student student = getStudentById(studentEdit.getId());
            student.setFirstName(studentEdit.getFirstName());
            student.setLastName(studentEdit.getLastName());
            student.setEmail(studentEdit.getEmail());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            student.setDateOfBirth(dateFormat.parse(studentEdit.getDateOfBirth()));
            student.setAge((new Date()).getYear()-student.getDateOfBirth().getYear());
            studentRepository.save(student);
            return student;
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
    public Student findStudentByEmail(String email){
        return studentRepository.findByEmail(email);
    }
    public void DeleteStudent(String id){
        studentRepository.deleteById(id);
    }

}
