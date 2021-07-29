package com.example.demo.othors.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SqlFinder {

    /**
     * SQL文を取得する
     *
     * @param path ファイルパス
     * @return SQL文
     */
    public static String get(String path) {
        Resource resource = new ClassPathResource(path);
        try (InputStream stream = resource.getInputStream()) {
            return StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException(path + " is not found!", e);
        }
    }
}
