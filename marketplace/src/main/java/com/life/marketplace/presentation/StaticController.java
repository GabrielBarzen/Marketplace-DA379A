package com.life.marketplace.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {
    @RequestMapping("/")
    public String home() {
        return "login.html";
    }

}
