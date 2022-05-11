package com.life.marketplace.PresentationLayer;

import com.life.marketplace.BusinessLogicLayer.ProductManagement;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController()
public class MarketplaceController {

    int testid = 0;
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts() {
        ProductManagement pm = new ProductManagement();
        return pm.getAllProductsJSON();
    }

    @RequestMapping(value = "/products/buy", method = RequestMethod.GET)
    public void buyButtonPressed(@RequestParam String productID, @RequestParam String username) {


        ProductManagement pm = new ProductManagement();
        pm.addToCart(username, UUID.fromString(productID));


    }

}
