package com.life.marketplace.PresentationLayer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {
    @RequestMapping("/")
    public String getDefault() {
        return "login.html";
    }

    @RequestMapping("/login")
    public String getLogin() {
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

    @RequestMapping("/offers")
    public String getOffers() {
        return "offers.html";
    }

    @RequestMapping("/sell")
    public String getSell() {
        return "sell.html";
    }
    @RequestMapping("/order-history")
    public String getOrderHistory() {
        return "order_history.html";
    }

}
