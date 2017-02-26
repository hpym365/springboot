package com.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

    @Bean(name = "queueDataSource")
    @Qualifier(value = "queueDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.queue")
    @Profile("queue")
    public DataSource queueDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "testDataSource")
    @Qualifier(value = "testDataSource")
    @Profile("test")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary")
    @Primary
    @Profile("pri")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    @Profile("sec")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

}
