package com.life.marketplace.PresentationLayer;

import com.life.marketplace.BusinessLogicLayer.ProductManagement;
import com.life.marketplace.BusinessLogicLayer.UserManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NotificationController {

    @GetMapping("/notifications/show")
    @ResponseBody
    public String getOffers(@RequestParam("username") String username) {
        UserManagement om = new UserManagement();
        return om.getNotificationsJSON(username);
    }

    @GetMapping("/notifications/itemList")
    @ResponseBody
    public String getListItems() {
        ProductManagement pm = new ProductManagement();
        return pm.getProductSellLists();
    }

    @PostMapping("/subscription/add")
    @ResponseBody
    public ResponseEntity<String> addSubscription(@RequestParam("username") String username, @RequestParam("type") String type) {
        UserManagement um = new UserManagement();
        boolean success = um.addSubscription(username, type);
        ResponseEntity<String> re;
        if (success) {
            re = new ResponseEntity<>("Subscription added successfully", HttpStatus.OK);
        } else {
            re = new ResponseEntity<>("Subscription not added successfully", HttpStatus.valueOf(409));
        }
        return re;
    }
}
