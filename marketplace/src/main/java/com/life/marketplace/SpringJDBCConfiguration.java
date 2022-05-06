package com.life.marketplace;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringJDBCConfiguration {
    @Bean
    public DataSource postgresqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://gabnet.se:5432/marketplace_da397a");
        dataSource.setUsername("dbadmin");
        dataSource.setPassword("XEHjqXmGh2GYT2zfjJFkpQR8TQjjsk9aHPPiynUHYVqc5ycnf6jM5by2FFncgGY2Mr9UJvaQKFkxnhy8BUQ72ra3TCZmyYFV3mDoFuxLZC3zML6b6Cqp286wb5GmFupj");
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplateBean() {
        JdbcTemplate template = new JdbcTemplate(postgresqlDataSource());
        return template;
    }
}
