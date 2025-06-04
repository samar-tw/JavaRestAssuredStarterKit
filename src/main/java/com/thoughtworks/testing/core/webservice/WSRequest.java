package com.thoughtworks.testing.core.webservice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class WSRequest {

    // GET method
    public Response get(String endpoint, Map<String, String> headers) {
        return RestAssured.given().headers(headers).get(endpoint);
    }

    // POST method
    public Response post(String endpoint, Map<String, String> headers, String payload) {
        return RestAssured.given().headers(headers).body(payload).post(endpoint);
    }

    // PUT method
    public Response put(String endpoint, Map<String, String> headers, String payload) {
        return RestAssured.given().headers(headers).body(payload).put(endpoint);
    }

    // DELETE method
    public Response delete(String endpoint, Map<String, String> headers) {
        return RestAssured.given().headers(headers).delete(endpoint);
    }

    // PATCH method
    public Response patch(String endpoint, Map<String, String> headers, String payload) {
        return RestAssured.given().headers(headers).body(payload).patch(endpoint);
    }
}