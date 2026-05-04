package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test(testName = "Get profile info test")
    public void updateProfileInfoTest() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Harish2729", "harish1234"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(), "Harish2729");
        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("Namma")
                .lastName("Bhat")
                .mobileNumber("9876543212")
                .email("harishcbhatupdate@email.com")
                .build();
        response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
        System.out.println(response.asPrettyString());
    }
}