package com.thoughtworks.testing.utils;

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
}
