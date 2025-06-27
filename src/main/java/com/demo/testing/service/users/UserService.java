package com.demo.testing.service.users;
import com.demo.testing.constants.Constant;
import com.demo.testing.core.webservice.WSRequest;
import com.demo.testing.utils.JsonUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class UserService {

    private final WSRequest wsRequest;

    public UserService() {
        this.wsRequest = new WSRequest();
    }

    public Response getUsersByPageNumber(Map<String, String> headers, int pageNumber) {
        String endpoint = Constant.UserEndpoints.GET_USERS + pageNumber;
        return wsRequest.get(endpoint, headers);
    }

    public Response createNewUser(Map<String, String> headers, String payload) {
        String endpoint = Constant.UserEndpoints.CREATE_USER;
        return wsRequest.post(endpoint, headers, payload);
    }

    public Response createUser(Map<String, String> headers, Map<String,Object> userData){
        String endpoint = Constant.UserEndpoints.CREATE_USER;
        String jsonTemplate = null;
        try {
            jsonTemplate = JsonUtil.loadJson("src/test/resources/request_body_template.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String payload = JsonUtil.replaceJsonPlaceholders(jsonTemplate, userData);
        return wsRequest.post(endpoint,headers,payload);
    }
} 