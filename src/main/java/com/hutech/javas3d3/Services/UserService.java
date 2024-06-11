package com.hutech.javas3d3.Services;

import com.hutech.javas3d3.Entities.User;
import com.hutech.javas3d3.Repositories.UserRepository;
import com.hutech.javas3d3.Untils.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String username, String password) throws GeneralSecurityException {
        String encryptedPassword = EncryptionUtil.encrypt(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) throws GeneralSecurityException {
        User user = userRepository.findByUsername(username);
        if (user != null && EncryptionUtil.decrypt(user.getPassword()).equals(password)) {
            return user;
        }
        return null;
    }
}
