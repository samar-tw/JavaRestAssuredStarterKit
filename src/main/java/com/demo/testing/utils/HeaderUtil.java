package com.demo.testing.utils;

import java.util.HashMap;
import java.util.Map;

public class HeaderUtil {
    public static Map<String, String> getHeaderWithAuth(String authToken) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        if (authToken != null) {
            headers.put("Authorization", "Bearer " + authToken);
        }
        return headers;
    }

    public static Map<String, String> getHeaderNoAuth() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public static Map<String, String> getHeaderWithApiKey() {
        String xApiKeyValue = System.getProperty("xApiKey");
        Map<String, String> headers = new HashMap<>();

        if(xApiKeyValue != null) {
            headers.put("Content-Type", "application/json");
            headers.put("x-api-key", xApiKeyValue);
        }
        else {
            System.out.println("API key value is missing");
        }
        return headers;
    }
} 