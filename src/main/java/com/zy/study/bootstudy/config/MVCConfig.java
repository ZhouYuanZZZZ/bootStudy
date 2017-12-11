package com.zy.study.bootstudy.config;


import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import java.util.List;


@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter{

    @Resource
    private BootFastJsonConfig fastJsonConfig;

    @Resource
    private FastJsonValueFilter fastJsonValueFilter;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();


        fastJsonConfig.setSerializeFilters(fastJsonValueFilter);
        fastConverter.setFastJsonConfig(fastJsonConfig);

        converters.add(fastConverter);
    }


}
