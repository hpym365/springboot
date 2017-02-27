package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springboot.entity.User;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryQueue",
        transactionManagerRef="transactionManagerQueue",
        basePackages= { "com.springboot.repository" }) //设置Repository所在位置
public class QueueDataSourceConfig {

	@Autowired //@Qualifier("queueDataSource")
    private DataSource queueDataSource;

	@Autowired
	private User aa;

    @Primary
    @Bean(name = "entityManagerQueue")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryQueue(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryQueue")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryQueue (EntityManagerFactoryBuilder builder) {
        System.out.println("123");
        System.out.println(aa);
        System.out.println("456");
    	return builder
                .dataSource(queueDataSource)
                .properties(getVendorProperties(queueDataSource))
                .packages("com.springboot.entity") //设置实体类所在位置
                .persistenceUnit("queuePersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerQueue")
    public PlatformTransactionManager transactionManagerQueue(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryQueue(builder).getObject());
    }
}
