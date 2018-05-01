package com.zy.study.bootstudy.utils;

import java.text.SimpleDateFormat;

public class DateUtil {

    private static SimpleDateFormat dataTimeDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat getDataTimeDateFormat(){
        return dataTimeDateFormat;
    }
}
