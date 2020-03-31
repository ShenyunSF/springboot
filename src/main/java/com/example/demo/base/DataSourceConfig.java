package com.example.demo.base;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


@Configuration
@PropertySource(value = "classpath:mysql.properties")
public class DataSourceConfig
{
    @Value("${db.driverClassName}")
    private String driverName;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${db.initialSize}")
    private int initialSize;

    @Value("${db.maxActive}")
    private int maxActive;

    @Value("${db.maxIdle}")
    private int maxIdle;

    @Value("${db.minIdle}")
    private int minIdle;

    @Value("${db.maxWait}")
    private int maxWait;


    @Value("${db.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;

    @Value("${db.defaultAutoCommit}")
    private boolean defaultAutoCommit;


    @Bean(name = "druidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource()
    {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverName);
        druidDataSource.setUrl(dbUrl);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxIdle(maxIdle);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setDefaultAutoCommit(defaultAutoCommit);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        return druidDataSource;
    }
}
