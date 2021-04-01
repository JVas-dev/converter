package ru.test.vasileva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.vasileva.domain.User;
import ru.test.vasileva.service.LoginService;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String login(User user) {
        return loginService.getUser(user);

    }
}

