package com.trace.trace.config;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * @author jbk-xiao
 * @program trace
 * @packagename com.trace.trace.config
 * @Description
 * @create 2021-02-07-10:05
 */
@Data
@Component
public class RedisIndexConfig {
    private HashMap<String, Integer> map;

    {
        ClassPathResource classPathResource = new ClassPathResource("redis.properties");
        try {
            InputStream inputStream = classPathResource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[1024];
            int n;
            while ((n = reader.read(buf)) > 0) {
                sb.append(new String(buf, 0, n));
            }
            String json = sb.toString();
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<String, Integer>>() {}.getType();
            map = gson.fromJson(json, type);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}