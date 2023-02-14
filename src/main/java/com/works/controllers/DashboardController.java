package com.works.controllers;

import com.works.entities.Login;
import com.works.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {
    final LoginService loginService;

    @GetMapping("dashboard")
    public String dashboard(Login login) {

        return "dashboard";
    }
}
