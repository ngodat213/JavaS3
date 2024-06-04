package com.hutech.javas3d3.Repositories;

import com.hutech.javas3d3.Entities.Role;
import com.hutech.javas3d3.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {

}
