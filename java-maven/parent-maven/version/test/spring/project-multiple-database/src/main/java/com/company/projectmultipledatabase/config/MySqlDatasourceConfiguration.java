package com.company.projectmultipledatabase.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MySqlDatasourceConfiguration {

    @ConfigurationProperties("spring.datasource.mysql")
    @Bean(name = "mySqlDataSourceProperties")
    public DataSourceProperties mySqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource() {
        return mySqlDataSourceProperties().initializeDataSourceBuilder().build();
    }

}
