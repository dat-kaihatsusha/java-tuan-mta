package com.example.demo.db1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.Repository1",
    entityManagerFactoryRef = "db1EntityManagerFactory",
    transactionManagerRef = "db1TransactionManager")
public class Database1Config {
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSourceProperties db1DataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean
  public DataSource db1DataSource() {
    return db1DataSourceProperties().initializeDataSourceBuilder().build();
  }

  @Bean(name = "db1EntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(db1DataSource())
        .packages("com.example.demo.entity")
        .persistenceUnit("db1")
        .build();
  }

  @Primary
  @Bean
  public JpaTransactionManager db1TransactionManager(@Qualifier("db1EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  /*@Primary
  @Bean(name = "transactionManager1")
  public PlatformTransactionManager transactionManager1(@Qualifier("db1EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }*/

}
