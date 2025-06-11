package com.thoughtworks.testing.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDataReader {

    @DataProvider(name = "jsonDataProvider")
    public Object[][] getData(Method method) throws IOException {
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();

        // Path to the testdata.json file
        File file = new File(System.getProperty("testDataFile"));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);

        JsonNode testDataArray = root.path(className).path(methodName);

        if (testDataArray.isMissingNode()) {
            throw new RuntimeException("No test data found for: " + className + " -> " + methodName);
        }

        List<Object[]> data = new ArrayList<>();

        for (JsonNode testDataNode : testDataArray) {
            JsonNode testDataValues = testDataNode.path("testData");
            List<String> params = new ArrayList<>();
            Iterator<JsonNode> elements = testDataValues.elements();
            while (elements.hasNext()) {
                params.add(elements.next().asText());
            }
            data.add(params.toArray());
        }

        return data.toArray(new Object[0][]);
    }
}