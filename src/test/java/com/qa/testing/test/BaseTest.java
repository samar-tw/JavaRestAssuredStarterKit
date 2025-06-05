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

    //Sample for POST Request to be updated with actual data
    @Test
    public void testCreateUser() throws Exception {
        // Load and replace template
        String jsonTemplate = JsonUtil.loadJson("src/test/resources/request_body_template.json");
        String[][] replacements = {
                {"name", "ABC XYZ"},
                {"email", "abc@example.com"},
                {"accountNumber", "01234567"}
        };
        String requestBody = JsonUtil.replaceJsonPlaceholders(jsonTemplate, replacements);

        // Post call
        RestAssured
                .given()
                .basePath("/api/users")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(201); // validate status or more assertions
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
