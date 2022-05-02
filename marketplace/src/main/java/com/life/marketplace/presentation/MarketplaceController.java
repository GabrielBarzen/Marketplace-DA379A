package com.life.marketplace.presentation;

import com.google.gson.Gson;
import com.life.marketplace.model.Products;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;


@RestController()
//@RequestMapping(value = "/api/v01")
public class MarketplaceController {

    int testid = 0;
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999,Calendar.OCTOBER,7);
        Products product = new Products();
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


}
