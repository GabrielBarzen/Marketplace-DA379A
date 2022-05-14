package com.life.marketplace.PresentationLayer;


import com.life.marketplace.BusinessLogicLayer.ProductManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController()
public class SellController {

    @RequestMapping(method = RequestMethod.GET, value = "/sell/itemList")
    public String getListItems() {
        ProductManagement pm = new ProductManagement();
        return pm.getProductSellLists();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sell/product")
    public ResponseEntity<String> sellProduct(
            @RequestParam String seller,
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam long dateOfMake,
            @RequestParam String type,
            @RequestParam String color,
            @RequestParam String condition) {
        ProductManagement pm = new ProductManagement();
        boolean success = pm.sellProduct(seller, name, price, new Date(dateOfMake), type, color, condition);
        {

            ResponseEntity<String> response;
            if (success) {
                response = new ResponseEntity<>("Product added successful", HttpStatus.OK);
            } else {
                response = new ResponseEntity<>("Add product rejected", HttpStatus.UNAUTHORIZED);
            }

            return response;
        }
    }
}
