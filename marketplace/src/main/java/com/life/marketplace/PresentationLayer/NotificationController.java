package com.life.marketplace.PresentationLayer;

import com.life.marketplace.BusinessLogicLayer.UserManagement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NotificationController {

    @GetMapping("/notifications/show")
    @ResponseBody
    public String getOffers(@RequestParam("username") String username) {
        UserManagement om = new UserManagement();
        return om.getNotificationsJSON(username);
    }
}
