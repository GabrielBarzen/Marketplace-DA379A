package com.life.marketplace.PresentationLayer;

import com.life.marketplace.BusinessLogicLayer.ProductManagement;
import com.life.marketplace.BusinessLogicLayer.UserManagement;
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
}
