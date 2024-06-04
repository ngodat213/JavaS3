package com.hutech.javas3d3.Services;

import com.hutech.javas3d3.Entities.Role;
import com.hutech.javas3d3.Entities.User;
import com.hutech.javas3d3.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllRoles() {
        return userRepository.findAll();
    }

    public User getRolesById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> {
                    throw  new RuntimeException("Khong tim thay ID");
                }
        );
    }

    public  void addUser(User user) {
        userRepository.save(user);
    }

    public User UpdateUser(User userEdit){
        try{
            userRepository.save(userEdit);
            return userEdit;
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
    public void DeleteUser(String id){
        userRepository.deleteById(id);
    }
}
