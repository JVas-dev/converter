package ru.test.vasileva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.vasileva.domain.User;
import ru.test.vasileva.repo.UserRepo;

@Service
public class LoginService {
    @Autowired
    UserRepo userRepo;

    public String getUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb == null) return "false";
        else return "true";
    }
}
