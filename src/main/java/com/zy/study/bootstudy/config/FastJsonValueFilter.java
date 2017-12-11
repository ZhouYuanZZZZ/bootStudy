package com.zy.study.bootstudy.config;

import com.alibaba.fastjson.serializer.ValueFilter;
import org.springframework.stereotype.Component;

@Component
public class FastJsonValueFilter implements ValueFilter {

    @Override
    public Object process(Object object, String name, Object value) {
        if(value == null){
            return "";
        }else {
            return value;
        }
    }
}
