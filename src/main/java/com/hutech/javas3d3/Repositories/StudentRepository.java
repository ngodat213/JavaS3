package com.hutech.javas3d3.Repositories;

import com.hutech.javas3d3.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student,String> {
    @Query("select s from Student s where s.email=?1")
    Student findByEmail(String email);
}
