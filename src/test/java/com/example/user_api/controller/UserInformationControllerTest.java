package com.example.user_api.controller;


import com.example.user_api.constant.ResultConstant;
import com.example.user_api.controller.api.UserInformationController;
import com.example.user_api.controller.request.UserInformationRequest;
import com.example.user_api.controller.response.GeneralResponse;
import com.example.user_api.controller.response.UserRegisterResponse;
import com.example.user_api.exception.AppException;
import com.example.user_api.service.UserInformationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserInformationControllerTest {
    @InjectMocks
    private UserInformationController userInformationController;
    @Mock
    private UserInformationService userInformationService;

    @Test
    public void shouldBeOK_WhenCreateUser() throws AppException {
        Mockito.when(userInformationService.createUser(Mockito.any(UserInformationRequest.class))).
                thenReturn(new UserRegisterResponse(ResultConstant.SUCCESS));

        ResponseEntity<GeneralResponse<UserRegisterResponse>> resp = userInformationController.createUser(mockCreateUserRequest());
        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertNotNull(resp.getBody());

        verify(userInformationService, times(1)).createUser(mockCreateUserRequest());
    }

    @Test
    public void shouldThrowException_WhenSaveProfile() throws AppException {
        Mockito.when(userInformationService.createUser(Mockito.any(UserInformationRequest.class))).
                thenThrow(new AppException("test exception"));

        ResponseEntity<GeneralResponse<UserRegisterResponse>> resp = userInformationController.createUser(mockCreateUserRequest());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resp.getStatusCode());
        assertNotNull(resp.getBody());
        assertNotNull(resp.getBody().getResult());

        verify(userInformationService, times(1)).createUser(mockCreateUserRequest());
    }
    private UserInformationRequest mockCreateUserRequest() {

        return new UserInformationRequest(123456,
                "tester",
                "password",
                "0879130344",
                "1990/08/11",
                "18000",
                "199010210344",
                "SILVER",
                "Kinjiro",
                "Kiosks",
                "123/12",
                "district",
                "subDistrict",
                "province",
                10150
        );
    }

}
