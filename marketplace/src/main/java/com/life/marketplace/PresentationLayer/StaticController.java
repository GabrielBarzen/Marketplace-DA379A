package com.life.marketplace.PresentationLayer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {
    @RequestMapping("/")
    public String getDefault() {
        return "login.html";
    }

    @RequestMapping("/registration")
    public String getRegister() {
        return "registration.html";
    }

    @RequestMapping("/marketplace")
    public String getMarketplace() {
        return "marketplace.html";
    }

    @RequestMapping("/cart")
    public String getCart() {
        return "cart.html";
    }

}
