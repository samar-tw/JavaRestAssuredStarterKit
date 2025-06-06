package com.qa.testing.test.service.users;

import com.qa.testing.test.BaseTest;
import com.thoughtworks.testing.service.users.UserService;
import com.thoughtworks.testing.utils.TestDataReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetUsers extends BaseTest {
    private final UserService userService = new UserService();

    @Test(dataProvider = "jsonDataProvider", dataProviderClass = TestDataReader.class,
    description = "Getting users by page number")
    public void getUsersByPageNumberTest(String pageNumber) {
        Response response = userService.getUsersByPageNumber(getNoAuthHeaders(), Integer.valueOf(pageNumber));
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }

    @Test(dataProvider = "jsonDataProvider", dataProviderClass = TestDataReader.class,
    description = "This is test to check names coming from test data file only. It does not make any service call.")
    public void getUserNames(String name1, String name2) {
        Assert.assertEquals(name1, "earth");
        Assert.assertEquals(name2, "mars");
    }
}
