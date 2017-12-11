package com.zy.study.bootstudy.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "odm")
public class JdbcProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String mybatisConfigLocationLocation;
    private String mapperScannerConfigurerBasePackage;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMybatisConfigLocationLocation() {
        return mybatisConfigLocationLocation;
    }

    public void setMybatisConfigLocationLocation(String mybatisConfigLocationLocation) {
        this.mybatisConfigLocationLocation = mybatisConfigLocationLocation;
    }

    public String getMapperScannerConfigurerBasePackage() {
        return mapperScannerConfigurerBasePackage;
    }

    public void setMapperScannerConfigurerBasePackage(String mapperScannerConfigurerBasePackage) {
        this.mapperScannerConfigurerBasePackage = mapperScannerConfigurerBasePackage;
    }
}
