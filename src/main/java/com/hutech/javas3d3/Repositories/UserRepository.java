package com.hutech.javas3d3.Repositories;

import com.hutech.javas3d3.Entities.Student;
import com.hutech.javas3d3.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,String> {

}
