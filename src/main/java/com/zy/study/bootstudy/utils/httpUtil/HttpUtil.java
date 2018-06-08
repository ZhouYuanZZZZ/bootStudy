package com.zy.study.bootstudy.utils.httpUtil;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    private static HttpClient httpClient;

    private static RequestConfig requestConfig;

    static {
        httpClient = HttpClients.createDefault();
        requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(2000)
                .build();
    }

    public static JsonResult post(URI uri, Map<String, String> paramMap) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setConfig(requestConfig);

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        for(Map.Entry<String,String> entry:paramMap.entrySet()){
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()))
        }

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8);
        httpPost.setEntity(entity);

        httpClient.execute(httpPost);
    }
}
