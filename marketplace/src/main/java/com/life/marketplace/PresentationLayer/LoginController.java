package com.life.marketplace.PresentationLayer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
//@RequestMapping(path = "/login")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public void loginUser(@RequestParam("username") String username, @RequestParam("password") String password){

        System.out.println("nice");
        System.out.println(username + " nice " + password);

    }

    @PostMapping("/++")
    public void loginUser(){
        System.out.println("nice");
        System.out.println("asdf");
    }
}
