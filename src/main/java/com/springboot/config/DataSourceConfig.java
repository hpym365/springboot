package com.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Bean(name = "queueDataSource")
	@Qualifier(value = "queueDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.queue")
	public DataSource queueDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "testDataSource")
	@Qualifier(value = "testDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.test")
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}

}
