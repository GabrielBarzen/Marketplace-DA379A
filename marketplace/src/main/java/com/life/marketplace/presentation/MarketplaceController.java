package com.life.marketplace.presentation;

import com.google.gson.Gson;
import com.life.marketplace.model.Products;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@RestController()
//@RequestMapping(value = "/api/v01")
public class MarketplaceController {


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts() {
        Products product = new Products();
        product.setId("01");
        product.setName("macbook");
        product.setPrice(20000000);
        product.setDate(new Date(1999,10,07));
        product.setType("electronics");
        product.setColor("green");
        product.setCondition("whack");
        product.setStatus("Not sold its broken what did you expect");
        product.setSeller("you :eyesemoji:");

        Gson gson = new Gson();
        return gson.toJson(product);
    }


}
