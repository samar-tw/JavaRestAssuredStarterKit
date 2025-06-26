package com.qa.testing.test.service.users;

import com.qa.testing.test.BaseTest;
import com.thoughtworks.testing.components.users.User;
import com.thoughtworks.testing.service.users.UserService;
import com.thoughtworks.testing.utils.FakerUtil;
import com.thoughtworks.testing.utils.JsonUtil;
import com.thoughtworks.testing.utils.Person;
import com.thoughtworks.testing.utils.TestDataReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static com.thoughtworks.testing.utils.JsonUtil.convertToMap;

public class UsersTest extends BaseTest {
    private final UserService userService = new UserService();
    private final FakerUtil fakerUtil = new FakerUtil();
    private final JsonUtil jsonUtil = new JsonUtil();

    @Test(dataProvider = "jsonDataProvider", dataProviderClass = TestDataReader.class)
    public void getUsersByPageNumberTest(String pageNumber) {
        Response response = userService.getUsersByPageNumber(getApiKeyHeader(), Integer.valueOf
                (pageNumber));
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }

    @Test
    public void testPostUsers() {
        User user = new User("name",2, 140.9);
        Response response = userService.createUser(getNoAuthHeaders(),convertToMap(user));
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }
    @Test
    public void postNewUserTest() {
        Person person = new Person();
        String name = person.getFirstName();
        String jobTitle = person.getJobTitle();
        Map<String, Object> newUserInfo = new HashMap<>();
        newUserInfo.put("name", name);
        newUserInfo.put("job", jobTitle);
        String reqBody = jsonUtil.updateJsonTemplateWithMapValues("src/test/resources/requestTemplates/createUser.json", newUserInfo);
        Response response = userService.createNewUser(getApiKeyHeader(),reqBody);
        Assert.assertEquals(response.getStatusCode(), 201, "Expected status code 201");
    }

    @Test(dataProvider = "jsonDataProvider", dataProviderClass = TestDataReader.class,
    description = "This is test to check names coming from test data file only. It does not make any service call.")
    public void getUserNamesTest(String name1, String name2) {
        Assert.assertEquals(name1, "earth");
        Assert.assertEquals(name2, "mars");
    }
}
