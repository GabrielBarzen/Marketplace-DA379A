package com.life.marketplace.PresentationLayer;

import com.google.gson.Gson;
import com.life.marketplace.model.Product;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;


@RestController()
public class MarketplaceController {

    int testid = 0;
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999,Calendar.OCTOBER,7);
        Product product = new Product();
        product.setId(String.valueOf(testid++));
        product.setName("macbook");
        product.setPrice(20000000);
        product.setDate(new Date(calendar.getTimeInMillis()));
        product.setType("electronics");
        product.setColor("green");
        product.setCondition("broken");
        product.setStatus("Not sold, its broken");
        product.setSeller("you \n" +
                "\uD83D\uDC40 ");
        Gson gson = new Gson();
        return gson.toJson(product);
    }

    @RequestMapping(value = "/products/buy={productID}", method = RequestMethod.GET)
    public void buyButtonPressed(@PathVariable String productID) {
        System.out.println(productID);
    }



}
