package com.life.marketplace.BusinessLogicLayer;

import com.google.gson.Gson;
import com.life.marketplace.DataAccessLayer.DatabaseAccess;
import com.life.marketplace.model.Offer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class OfferManagement {

    DatabaseAccess db = new DatabaseAccess();

    private ArrayList<Offer> getOffers(String username) {
        ArrayList<Offer> offers = new ArrayList<>();
        try {
            offers = new ObjectCreator().createOfferList(db.f_get_offers(username));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offers;
    }

    public String getOffersJSON(String username) {
        ArrayList<Offer> offers = getOffers(username);
        return new Gson().toJson(offers);
    }

    public boolean acceptOffer(String uuid) {
        return db.p_confirm_order(UUID.fromString(uuid));
    }

    public boolean declineOffer(String uuid) {
        return db.p_deny_order(UUID.fromString(uuid));
    }
}
