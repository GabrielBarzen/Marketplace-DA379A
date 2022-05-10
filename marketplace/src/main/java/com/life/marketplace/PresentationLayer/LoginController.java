package com.life.marketplace.PresentationLayer;

import com.life.marketplace.BusinessLogicLayer.UserManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> loginUser(@RequestParam("username") String username,
                                            @RequestParam("password") String password) {
        System.out.println(username + " nice " + password);

        ResponseEntity<String> response;
        boolean loginSuccessful = new UserManagement().loginUser(username, password);

        if (loginSuccessful) {
            response = new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
        }

        return response;
    }

    @PostMapping("/++")
    public void loginUser(){
        System.out.println("nice");
        System.out.println("asdf");
    }
}
