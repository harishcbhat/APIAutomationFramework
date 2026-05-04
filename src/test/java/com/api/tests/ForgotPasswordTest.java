package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test(testName = "Verify Account Creation Test")
    public void createAccountTest() {
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("namratha@gmail.com");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());
    }
}