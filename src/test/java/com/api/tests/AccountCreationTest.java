package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(testName = "Verify Account Creation Test")
    public void createAccountTest() {
        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .userName("namratha2729")
                .firstName("Namratha")
                .email("namratha@gmail.com")
                .lastName("Bhat")
                .password("namratha1234")
                .mobileNumber("9876543216").build();
        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());
    }
}
