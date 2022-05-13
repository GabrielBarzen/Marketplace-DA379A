package com.life.marketplace.PresentationLayer;

import com.life.marketplace.BusinessLogicLayer.ProductManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.sql.Date;

@RestController
public class OrderHistoryController {

    @RequestMapping(method = RequestMethod.GET, value = "/order-history/show")
    public String getOrderHistory(
            @RequestParam String username,
            @RequestParam long beginDate,
            @RequestParam long endDate ){


        System.out.println("Searchign for uname : " + username + " with start time : " + beginDate + " and end time : " + endDate);
        String startDateString = "1970-01-01";
        Date startDate = null;
        Date stopDate = null;
        startDate = Date.valueOf(startDateString);
        stopDate = new Date(System.currentTimeMillis());

        if (beginDate != -1) {
            startDate = new Date(beginDate);
        }
        if (endDate != -1) {
            stopDate = new Date(endDate);
        }
        ProductManagement pm = new ProductManagement();
        System.out.println(pm.showPurchaseHistory(username, startDate, stopDate));
        return pm.showPurchaseHistory(username, startDate, stopDate);
    }



}
