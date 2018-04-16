package com.zy.study.bootstudy.config;



import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;


@Configuration
public class Odm implements EnvironmentAware {

    private static final Logger logger = LoggerFactory.getLogger(Odm.class);


    private Environment env;


    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //扫描Mapper配置文件与接口的包名
        mapperScannerConfigurer.setBasePackage(env.getProperty("odm.mapperScannerConfigurerBasePackage"));
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

        return mapperScannerConfigurer;
    }

    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setUrl(env.getProperty("odm.url"));
        basicDataSource.setDriverClassName(env.getProperty("odm.driverClassName"));
        basicDataSource.setUsername(env.getProperty("odm.username"));
        basicDataSource.setPassword(env.getProperty("odm.password"));

        return basicDataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;

    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

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
