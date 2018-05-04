package com.zy.study.bootstudy;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest{

    @Test
    public void test0(){
        Pattern xlsPatern = Pattern.compile("\\.xls$");
        Pattern xlsxPatern = Pattern.compile("\\.xlsx$");

        String s1 = "sdrr.xls";

        Matcher matcherXls = xlsPatern.matcher(s1);
        Matcher matcher1Xlsx = xlsxPatern.matcher(s1);

        if(matcherXls.find()){
            System.out.println("xls");
        }

        if(matcher1Xlsx.matches()){
            System.out.println("xlsx");
        }

    }

    @Test
    public void test1(){
        String reg = "[a-zA-Z][0-9]";

        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher("ewfjeriofr5grtg4rth8th7ytjhyt5j4y8j7uyuyj4S8F9R");

        while(matcher.matches()){
            String group = matcher.group();
            System.out.println(group);
        }



    }
}
