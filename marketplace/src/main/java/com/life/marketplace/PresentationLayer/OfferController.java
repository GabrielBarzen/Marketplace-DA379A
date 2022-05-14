package com.life.marketplace.PresentationLayer;

import com.life.marketplace.BusinessLogicLayer.OfferManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OfferController {

    @GetMapping("/offers/show")
    @ResponseBody
    public String getOffers(@RequestParam("username") String username) {
        OfferManagement om = new OfferManagement();
        return om.getOffersJSON(username);
    }

    @PutMapping("/offers/accept")
    public ResponseEntity<String> acceptOffer(@RequestParam("orderid") String uuid) {
        ResponseEntity<String> response;
        boolean success = new OfferManagement().acceptOffer(uuid);

        if (success) {
            response = new ResponseEntity<>("Order accepted successful", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Order acceptation failed", HttpStatus.UNAUTHORIZED);
        }

        return response;
    }

    @PutMapping("offers/decline")
    public ResponseEntity<String> declineOffer(@RequestParam("orderid") String uuid) {
        ResponseEntity<String> response;
        boolean success = new OfferManagement().declineOffer(uuid);

        if (success) {
            response = new ResponseEntity<>("Order declination successful", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Order declination failed", HttpStatus.UNAUTHORIZED);
        }

        return response;
    }
}
