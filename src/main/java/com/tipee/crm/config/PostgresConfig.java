package com.tipee.crm.config;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = {"com.tipee.crm.repository"})
public class PostgresConfig extends AbstractR2dbcConfiguration {
    @Value("${DATABASE_HOST}")
    String hostName;

    @Value("${DATABASE_NAME}")
    String database;

    @Value("${DATABASE_SCHEMA}")
    String schema;

    @Value("${DATABASE_USER}")
    String username;

    @Value("${DATABASE_PASSWORD}")
    String password;

    @Value("${DATABASE_PORT}")
    int port;
    
    @Bean
    @Override
    public PostgresqlConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .host(hostName)
                .database(database)
                .port(port)
                .username(username)
                .password(password).build());
    }
}
