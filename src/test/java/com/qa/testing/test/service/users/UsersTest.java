package com.qa.testing.test.service.users;

import com.qa.testing.test.BaseTest;
import com.thoughtworks.testing.components.users.User;
import com.thoughtworks.testing.service.users.UserService;
import com.thoughtworks.testing.utils.TestDataReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.thoughtworks.testing.utils.JsonUtil.convertToMap;

public class UsersTest extends BaseTest {
    private final UserService userService = new UserService();

    @Test
    public void testGetUsers() {
        Response response = userService.getUsersByPageNumber(getNoAuthHeaders(), 2);
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }

    @Test
    public void testPostUsers() {
        User user = new User("name",2, 140.9);
        Response response = userService.createUser(getNoAuthHeaders(),convertToMap(user));
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }

    @Test(dataProvider = "jsonDataProvider", dataProviderClass = TestDataReader.class,
    description = "This is test to check names coming from test data file only. It does not make any service call.")
    public void getUserNames(String name1, String name2) {
        Assert.assertEquals(name1, "earth");
        Assert.assertEquals(name2, "mars");
    }
}
