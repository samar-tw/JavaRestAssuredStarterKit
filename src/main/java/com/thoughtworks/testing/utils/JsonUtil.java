package com.thoughtworks.testing.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.lang.reflect.Field;
import java.util.HashMap;

public class JsonUtil {
    public static String loadJson(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static String replaceJsonPlaceholders(String json, Map<String, Object> values) {
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            String placeholder = "{{" + entry.getKey() + "}}";
            json = json.replace(placeholder, entry.getValue().toString());
        }
        return json;
    }

    public String updateJsonTemplateWithMapValues(String jsonTemplatePath, Map<String, Object> values) {
        try {
            String json = new String(Files.readAllBytes(Paths.get(jsonTemplatePath)));
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String placeholder = "{$" + entry.getKey() + "}";
                json = json.replace(placeholder, entry.getValue().toString());
            }
            return json;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read or update JSON template", e);
        }
    }

    public static Map<String, Object> convertToMap(Object obj) {
        Map<String, Object> result = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                result.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
