package com.life.marketplace.data_access;

import com.life.marketplace.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


@Component
public class DatabaseAccess {

    @Autowired
    public DatabaseAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        DatabaseAccess.dbaccess = this;
    }

    static DatabaseAccess dbaccess;
    static DatabaseAccess getDBAccess () {
        return dbaccess;
    }



    private JdbcTemplate jdbcTemplate;

    public List<Products> f_get_all_products() {

        String sql = "call f_get_all_products()";

        return jdbcTemplate.queryForList(sql, Products.class);
    }

    public void p_add_subscription(String username, String type) {

        String sql = "CALL p_add_subscription(" + username + ", " + type + ")";

        jdbcTemplate.execute(sql);
        //jdbcTemplate.execute("CALL p_add_subscription(?,?)", username, type);
    }

    public void p_create_order(String username) {
        jdbcTemplate = new JdbcTemplate();
    }

    public void p_delete_user(String username) {
        jdbcTemplate = new JdbcTemplate();

    }

    public void p_remove_product(UUID uuid) {
        jdbcTemplate = new JdbcTemplate();
        String sql = String.format("CALL p_remove_product(%s)", uuid);
        jdbcTemplate.execute(sql);
    }

    public void p_update_read_status(String username) {
        jdbcTemplate = new JdbcTemplate();
        String sql = String.format("CALL p_update_read_status(%s)", username);
        jdbcTemplate.execute(sql);
    }


}
