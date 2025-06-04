package com.thoughtworks.testing.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static final Properties props = new Properties();

    /**
     * Loads a properties file dynamically.
     * @param filePath - The path of the properties file to load.
     */
    public static void loadProperties(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            props.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load properties file: " + filePath, e);
        }
    }

    /**
     * Retrieves a property value by its key.
     * @param key - The property key.
     * @return - The property value, or null if not found.
     */
    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}
