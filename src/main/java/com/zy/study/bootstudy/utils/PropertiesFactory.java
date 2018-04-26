package com.zy.study.bootstudy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class PropertiesFactory {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesFactory.class);

    private static String classPath = PropertiesFactory.class.getResource("/").getPath();

    private static Properties appProperties = new Properties();

    static {
//        Reader appPropertiesReader = getReader("application-dev.properties");
//        if(appPropertiesReader != null){
//            try {
//                appProperties.load(appPropertiesReader);
//            } catch (IOException e) {
//                logger.error("init error",e);
//            }
//        }

    }

    public static Properties getAppProperties() {
        return appProperties;
    }

    private static Reader getReader(String fileName) {
        try {
            String path = classPath + fileName;
            File file = new File(path);
            logger.info("path:{}",path);
            FileReader fileReader = new FileReader(file);

            return fileReader;

        }catch (Exception e){
            logger.error("getReader error",e);
            return null;
        }


    }
}
