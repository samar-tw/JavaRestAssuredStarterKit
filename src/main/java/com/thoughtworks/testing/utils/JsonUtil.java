package com.thoughtworks.testing.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtil {
    public static String loadJson(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static String replaceJsonPlaceholders(String json, String[][] values) {
        for (String[] pair : values) {
            json = json.replace("{{" + pair[0] + "}}", pair[1]);
        }
        return json;
    }
}
