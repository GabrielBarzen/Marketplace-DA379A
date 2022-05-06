package com.life.marketplace.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
//@RequestMapping(path = "/login")
public class LoginController {
    //@RequestMapping(value="/login?uname={username}&pword={password}", method=RequestMethod.POST)

    @RequestMapping("/login")
    public String getLogin() {
        return "login.html";
    }

    @RequestMapping(value = "/login/username={username}&password={password}", method = RequestMethod.POST)
    public void loginUser(@PathVariable String username, @PathVariable String password){
        System.out.println("nice");
        System.out.println(username + " nice " + password);

    }

    @PostMapping("/++")
    public void loginUser(){
        System.out.println("nice");
        System.out.println("asdf");
    }
}
