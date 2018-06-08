package com.zy.study.bootstudy.utils.httpUtil;

import com.alibaba.fastjson.JSON;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static HttpClient httpClient;

    private static RequestConfig requestConfig;

    static {
        httpClient = HttpClients.createDefault();
        requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(2000)
                .build();
    }

    public static JsonResult post(URI uri, Map<String, String> paramMap)  {

        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccessFlag(true);
        long start = 0;
        long end=0;

        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setConfig(requestConfig);

            List<NameValuePair> nameValuePairs = new ArrayList<>();
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8);
            httpPost.setEntity(entity);

            start = System.currentTimeMillis();
            HttpResponse response = httpClient.execute(httpPost);
            end = System.currentTimeMillis();

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String responseString = EntityUtils.toString(responseEntity, "UTF-8");
                jsonResult.setResult(responseString);
            }else{
                jsonResult.setSuccessFlag(false);
            }
        } catch (Exception e) {
            logger.error("post error",e);
            jsonResult.setSuccessFlag(false);
        }

        logger.info("cost time:{}",end-start);
        logger.info("request info:{} ---->{}", JSON.toJSONString(uri),JSON.toJSON(paramMap));

        return jsonResult;
    }

    public static JsonResult post(URI uri, String requestJson)  {

        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccessFlag(true);
        long start = 0;
        long end=0;

        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setConfig(requestConfig);

            StringEntity entity = new StringEntity(requestJson);
            entity.setContentType(ContentType.APPLICATION_JSON.getMimeType());
            httpPost.setEntity(entity);

            start = System.currentTimeMillis();
            HttpResponse response = httpClient.execute(httpPost);
            end = System.currentTimeMillis();

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String responseString = EntityUtils.toString(responseEntity, "UTF-8");
                jsonResult.setResult(responseString);
            }else{
                jsonResult.setSuccessFlag(false);
            }
        } catch (Exception e) {
            logger.error("post error",e);
            jsonResult.setSuccessFlag(false);
        }

        logger.info("cost time:{}",end-start);
        logger.info("request info:{} ----> ", JSON.toJSONString(uri),requestJson);

        return jsonResult;

    }

    public static JsonResult get(URI uri) {

        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccessFlag(true);
        long start = 0;
        long end=0;

        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setConfig(requestConfig);

            start = System.currentTimeMillis();
            HttpResponse response = httpClient.execute(httpGet);
            end = System.currentTimeMillis();

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String responseString = EntityUtils.toString(responseEntity, "UTF-8");
                jsonResult.setResult(responseString);
            }else{
                jsonResult.setSuccessFlag(false);
            }
        } catch (Exception e) {
            logger.error("post error",e);
            jsonResult.setSuccessFlag(false);
        }

        logger.info("cost time:{}",end-start);
        logger.info("request info:{} ----> ", JSON.toJSONString(uri));

        return jsonResult;

    }
}
