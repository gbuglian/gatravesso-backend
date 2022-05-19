package com.br.gatravesso.app.mysql.infra;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.sql.SQLException;

@Profile(value = "local")
@Generated
@EntityScan(basePackages = {"com.br.gatravesso.app.mysql.entity"})
@EnableJpaRepositories({"com.br.gatravesso.app.mysql.repository"})
@Configuration

public class conectionHikariLocal {

    @Value("${spring.datasource.hikari.username}")
    private String dbUser;

    @Value("${spring.datasource.hikari.password}")
    private String dbPass;

    @Value("${spring.datasource.url}")
    private String dbHost;

    @Value("${spring.datasource.hikari.driver-class-name}")
    private String dbDriver;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws InterruptedException, SQLException{
        var hikariConfig = new HikariDataSource();
        hikariConfig.setJdbcUrl(dbHost);
        hikariConfig.setUsername(dbUser);
        hikariConfig.setPassword(dbPass);
        hikariConfig.setDriverClassName(dbDriver);
        return hikariConfig;
    }
}
