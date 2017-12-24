package com.zy.study.bootstudy.entity;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "odm")
public class MybatisConfig {

    private String mybatisConfigLocationLocation;
    private String mapperScannerConfigurerBasePackage;

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
