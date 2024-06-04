package com.hutech.javas3d3.Services;

import com.hutech.javas3d3.Entities.Classroom;
import com.hutech.javas3d3.Entities.Role;
import com.hutech.javas3d3.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServices {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRolesById(String id){
        return roleRepository.findById(id).orElseThrow(
                () -> {
                    throw  new RuntimeException("Khong tim thay ID");
                }
        );
    }

    public  void addRole(Role role) {
        roleRepository.save(role);
    }

    public Role UpdateClassroom(Role roleEdit){
        try{
            roleRepository.save(roleEdit);
            return roleEdit;
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
    public void DeleteRole(String id){
        roleRepository.deleteById(id);
    }
}
