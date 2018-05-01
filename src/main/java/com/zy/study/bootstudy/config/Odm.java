package com.zy.study.bootstudy.config;



import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import oracle.jdbc.xa.client.OracleXADataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
public class Odm implements EnvironmentAware {

    private static final Logger logger = LoggerFactory.getLogger(Odm.class);


    private Environment env;




    @Bean(name = "oracleDb1")
    public DataSource oracleDb1() throws SQLException {

        OracleXADataSource mysqlXaDataSource = new OracleXADataSource();

        mysqlXaDataSource.setURL(env.getProperty("odm1.url"));
        mysqlXaDataSource.setPassword(env.getProperty("odm1.username"));
        mysqlXaDataSource.setUser(env.getProperty("odm1.username"));

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);


        return xaDataSource;
    }

    @Bean(name = "mysqlDb1")
    public DataSource dataSource1(){

        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(env.getProperty("odm.url"));
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(env.getProperty("odm.password"));
        mysqlXaDataSource.setUser(env.getProperty("odm.username"));

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);


        return xaDataSource;
    }

//    @Bean
//    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
//        dataSourceTransactionManager.setDataSource(dataSource);
//        return dataSourceTransactionManager;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource){
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dataSource);
//        return jdbcTemplate;
//
//    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("mysqlDb1") DataSource mysqlDb1){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mysqlDb1);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setConfigLocation(resolver.getResources(env.getProperty("odm.mybatisConfigLocationLocation"))[0]);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException(e);
        }

        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory1(@Qualifier("oracleDb1") DataSource oracleDb1){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(oracleDb1);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setConfigLocation(resolver.getResources(env.getProperty("odm1.mybatisConfigLocationLocation"))[0]);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException(e);
        }

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //扫描Mapper配置文件与接口的包名
        mapperScannerConfigurer.setBasePackage(env.getProperty("odm.mapperScannerConfigurerBasePackage"));
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

        return mapperScannerConfigurer;
    }

    @Bean
    public tk.mybatis.spring.mapper.MapperScannerConfigurer  mapperScannerConfigurer1(){

        tk.mybatis.spring.mapper.MapperScannerConfigurer mapperScannerConfigurer = new tk.mybatis.spring.mapper.MapperScannerConfigurer();
        //扫描Mapper配置文件与接口的包名
        mapperScannerConfigurer.setBasePackage(env.getProperty("odm1.mapperScannerConfigurerBasePackage"));
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory1");

        return mapperScannerConfigurer;
    }

//    @Bean("sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ResourceLoader resourceLoader, GlobalConfiguration globalConfiguration) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setTypeAliasesPackage("com.zy.study.bootstudy.entity");
//        return sqlSessionFactory.getObject();
//    }


    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}
