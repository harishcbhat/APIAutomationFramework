package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test(testName = "Verify if login API is working")
    public void loginTest() {
        LoginRequest loginRequest = new LoginRequest("Harish2729", "harish1234");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getEmail(), "harishcbhat@gmail.com");
        Assert.assertEquals(loginResponse.getId(), 5084);
        Assert.assertNotNull(loginResponse.getToken());
    }
}
