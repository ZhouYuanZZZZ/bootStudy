package com.zy.study.bootstudy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;

public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static File createFile(String path) {
        File file = null;
        try {
            if(StringUtils.isEmpty(path)){
                throw new IOException("path error");
            }else {
                file = new File(path);
                if(file.exists()){
                    file.delete();
                }else {
                    if(!file.getParentFile().exists()){
                        file.getParentFile().mkdirs();
                    }
                }
                file.createNewFile();
                return file;
            }
        }catch (Exception e){
           logger.error("createFile error",e);
           return null;
        }
    }

    public static void copyInputStreamToFile(InputStream inputStream,File file)  {
        int size = (int) (1024*1024*0.5);
        int len;
        boolean eof = false;//是否到达文件末尾
        byte[]  buffer = new byte[size];//每次读取的字节

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream =  new FileOutputStream(file);

            while ((len = inputStream.read(buffer))>0){
                fileOutputStream.write(buffer,0,len);
            }
            fileOutputStream.flush();
        } catch (IOException e) {
            logger.error("copyInputStreamToFile error", e);
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                logger.error("fileOutputStream.close error", e);
            }

            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error("inputStream.close error", e);
            }
        }


    }
}
