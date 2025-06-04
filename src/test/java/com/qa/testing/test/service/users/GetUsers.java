package com.qa.testing.test.service.users;

import com.qa.testing.test.BaseTest;
import com.thoughtworks.testing.service.users.UserService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUsers extends BaseTest {
    private final UserService userService = new UserService();

    @Test
    public void testGetUsers() {
        Response response = userService.getUsersByPageNumber(getNoAuthHeaders(), 2);
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }

}
