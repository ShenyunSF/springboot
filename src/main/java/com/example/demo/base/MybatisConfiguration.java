/*
package com.example.demo.base;

import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

*/
/**
 * created by zhenzhong on 2019/12/2
 *//*

@Configuration
@MapperScan(basePackages = "com.example.demo.mapper")
public class MybatisConfiguration
{

    public SqlSessionFactory sqlSessionFactory(@Qualifier("druidDataSource") DataSource dataSource)
    {
        VFS.addImplClass(SpringBootVFS.class);
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try
        {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapping/*Mapper.xml"));
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
            return sqlSessionFactory;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    @Bean(name = "mybatisTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("druidDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
*/
