package com.qa.testing.test;

import com.thoughtworks.testing.config.ConfigManager;
import com.thoughtworks.testing.utils.HeaderUtil;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

import java.util.Map;

public abstract class BaseTest {
    protected Map<String, String> headers;

    public BaseTest() {
        // Setting headers for the test class
//        headers = HeaderUtil.getHeaderNoAuth();
    }

    protected static Map<String, String> getNoAuthHeaders() {
        return HeaderUtil.getHeaderNoAuth();
    }

    /**
     * Method to set the RestAssured baseURI.
     */
    @BeforeSuite
    protected void setBaseURI() {
        RestAssured.baseURI =getHostUrl();
    }

    /**
     * Reads 'dev_config.properties' and returns the 'hosturl' property.
     * @return the hosturl property value (e.g., "https://reqres.in").
     */
    protected static String getHostUrl() {
        // Read the 'env' system property (default to "dev" if null)
        String environment = System.getProperty("env");
        if (environment == null || environment.isEmpty()) {
            environment = "dev";
        }

        // Construct the properties file name dynamically
        String propertiesFileName = environment + "_config.properties";

        // Load the properties file
        ConfigManager.loadProperties("src/test/resources/" + propertiesFileName);

        // Return the hosturl property
        return ConfigManager.getProperty("hosturl");
    }
}
