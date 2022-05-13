package com.life.marketplace.PresentationLayer;

import com.life.marketplace.BusinessLogicLayer.UserManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class RegistrationController {

    @PostMapping(path = "/register")
    public ResponseEntity<String> registerAccount(@RequestParam("username") String username,
                                                  @RequestParam("password") String password,
                                                  @RequestParam("email") String email,
                                                  @RequestParam("birthdate") String birthDate,
                                                  @RequestParam("firstname") String firstName,
                                                  @RequestParam("lastname") String lastName) {
//        System.out.printf("%s %s %s %s %s %s\n", username, password, email, Date.valueOf(birthDate), firstName, lastName);
        ResponseEntity<String> response;
        boolean loginSuccessful = new UserManagement().registerUser(username, password, email, Date.valueOf(birthDate), firstName, lastName);

        if (loginSuccessful) {
            response = new ResponseEntity<>("Registration successful", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Registration failed", HttpStatus.UNAUTHORIZED);
        }

        return response;
    }


}
