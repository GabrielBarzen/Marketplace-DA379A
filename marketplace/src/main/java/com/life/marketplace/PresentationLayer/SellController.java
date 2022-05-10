package com.life.marketplace.PresentationLayer;


import com.life.marketplace.BusinessLogicLayer.ProductManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class SellController {

    @RequestMapping(method = RequestMethod.GET, value = "/sell/itemList")
    public String getListItems() {
        ProductManagement pm = new ProductManagement();
        return pm.getProductSellLists();
    }
}
