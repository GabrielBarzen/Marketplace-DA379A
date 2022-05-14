package com.life.marketplace.PresentationLayer;

import com.life.marketplace.BusinessLogicLayer.ProductManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> buyButtonPressed(@RequestParam String productID, @RequestParam String username) {


        ProductManagement pm = new ProductManagement();
        boolean success = pm.addToCart(username, UUID.fromString(productID));

        ResponseEntity<String> response;
        if (success) {
            response = new ResponseEntity<>("Product added to cart", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Tried to buy own product", HttpStatus.UNAUTHORIZED);
        }
        return response;
    }

}
