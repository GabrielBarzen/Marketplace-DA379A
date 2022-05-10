package com.life.marketplace.BusinessLogicLayer;

import com.life.marketplace.DataAccessLayer.DatabaseAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManagement {
    public boolean loginUser(String username, String password) {
        DatabaseAccess db = new DatabaseAccess();
        String response = "kaozzzz";
        boolean success = false;
        ResultSet rs = null;

        try {
            rs = db.f_login_user(username, password);

            if (rs.next()) {
                response = rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (response != null && response.equals(username)) {
            success = true;
        }

        return success;
    }
}
