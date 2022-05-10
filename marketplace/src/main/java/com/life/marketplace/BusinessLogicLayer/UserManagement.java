package com.life.marketplace.BusinessLogicLayer;

import com.life.marketplace.DataAccessLayer.DatabaseAccess;

public class UserManagement {
    public boolean loginUser(String username, String password) {
        DatabaseAccess db = new DatabaseAccess();
//        ResultSet rs = db.loginUser(username, password);

        return false;
    }
}
