package com.example.demo.db2;

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
@EnableJpaRepositories(basePackages = "com.example.demo.repository2",
    entityManagerFactoryRef = "db2EntityManagerFactory",
    transactionManagerRef = "db2TransactionManager")
public class Database2Config {
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.db2")
  public DataSourceProperties db2DataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean
  public DataSource db2DataSource() {
    return db2DataSourceProperties().initializeDataSourceBuilder().build();
  }

  @Bean(name = "db2EntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(db2DataSource())
        .packages("com.example.demo.entity2")
        .persistenceUnit("db2")
        .build();
  }

  @Primary
  @Bean
  public JpaTransactionManager db2TransactionManager(@Qualifier("db2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  /*@Primary
  @Bean(name = "transactionManager2")
  public PlatformTransactionManager transactionManager2(@Qualifier("db2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }*/

}
