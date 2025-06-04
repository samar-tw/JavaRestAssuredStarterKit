package com.thoughtworks.testing.service.users;
import com.thoughtworks.testing.constants.Constant;
import com.thoughtworks.testing.core.webservice.WSRequest;
import io.restassured.response.Response;

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
}