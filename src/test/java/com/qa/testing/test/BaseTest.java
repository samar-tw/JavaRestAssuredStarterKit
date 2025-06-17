package com.qa.testing.test;

import com.thoughtworks.testing.config.ConfigManager;
import com.thoughtworks.testing.utils.HeaderUtil;
import com.thoughtworks.testing.utils.JsonUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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

    protected static Map<String, String> getApiKeyHeader(){
        return HeaderUtil.getHeaderWithApiKey();
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
    protected String getHostUrl() {
        // Read the 'env' system property (default to "dev" if null)
        String environment = getEnv();

        // Construct the properties file name dynamically
        String propertiesFileName = environment + "_config.properties";

        // Load the properties file
        ConfigManager.loadProperties("src/test/resources/" + propertiesFileName);

        // Return the hosturl property
        return ConfigManager.getProperty("hosturl");
    }
    @BeforeSuite
    protected static void setTestDataFile() {
        if (System.getProperty("testDataFile") == null) {
            String environment = getEnv();
            String testDataFileNameWithPath = "src/test/resources/testdata/" + environment + "_test_data.json";
            System.setProperty("testDataFile", testDataFileNameWithPath);
        }
    }
    protected static String getEnv() {
        String env = System.getProperty("env");
        if (env == null || env.isEmpty()) {
            env = "dev"; // Default environment
        }
        return env;
    }
}
