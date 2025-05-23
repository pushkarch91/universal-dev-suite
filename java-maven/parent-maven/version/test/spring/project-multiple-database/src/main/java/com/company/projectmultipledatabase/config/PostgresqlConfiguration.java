package com.company.projectmultipledatabase.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(basePackages = "com.company.projectmultipledatabase.orderrepository",
        entityManagerFactoryRef = "postgresqlEntityManagerFactoryBean",
        transactionManagerRef = "postgresqlTransactionManager")
public class PostgresqlConfiguration {

    @Bean
    LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
                                                                              @Qualifier("postgresqlDataSource") DataSource dataSource) {
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.company.projectmultipledatabase.orderentity")
                .build();
    }

    @Bean
    PlatformTransactionManager postgresqlTransactionManager(@Qualifier("postgresqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        assert localContainerEntityManagerFactoryBean.getObject() != null;
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }
}
