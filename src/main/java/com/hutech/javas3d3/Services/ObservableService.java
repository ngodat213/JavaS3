// UserService.java
package com.hutech.javas3d3.Services;

import com.hutech.javas3d3.Entities.Observable;
import com.hutech.javas3d3.Entities.User;
import com.hutech.javas3d3.Repositories.ObservableRepository;
import com.hutech.javas3d3.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ObservableService {
    @Autowired
    private ObservableRepository observableRepository;

    public void saveLoginTime(User user) {
        Observable observable = new Observable();
        observable.setUser(user);
        observable.setTimeIn(LocalDateTime.now());
        observable.setStatus("Login");
        observableRepository.save(observable);
    }

    public void saveLogoutTime(User user) {
        Observable observable = observableRepository.findTopByUserOrderByIdDesc(user);
        if (observable != null) {
            observable.setTimeOut(LocalDateTime.now());
            observable.setStatus("Logout");
            observableRepository.save(observable);
        }
    }
}
