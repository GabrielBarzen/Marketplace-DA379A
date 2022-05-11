package com.life.marketplace.PresentationLayer;

import com.life.marketplace.BusinessLogicLayer.ProductManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class CartController {


    @RequestMapping(method = RequestMethod.GET, value = "/cart/show")
    public String getCartForUser(@RequestParam String username){
        ProductManagement pm = new ProductManagement();
        String json = pm.getCartForUserJSON(username);
        return json;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cart/remove")
    public ResponseEntity<String> removeCart(@RequestParam String uuid){

        System.out.println("removing : " + uuid);
        ProductManagement pm = new ProductManagement();
        boolean bool = pm.userRemoveCart(uuid);
        return bool ? new ResponseEntity<String>("Removed Cart", HttpStatus.OK) : new ResponseEntity<String>("Could not remove cart", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cart/buy")
    public ResponseEntity<String> checkoutCart(@RequestParam String uuid){

        System.out.println("buying : " + uuid);
        ProductManagement pm = new ProductManagement();
        boolean bool = pm.userConfirmCart(uuid);
        return bool ? new ResponseEntity<String>("Removed Order", HttpStatus.OK) : new ResponseEntity<String>("Could not checkout order", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
