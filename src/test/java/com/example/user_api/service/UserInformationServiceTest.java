package com.example.user_api.service;


import com.example.user_api.constant.Constant;
import com.example.user_api.controller.response.UserInformationResponse;
import com.example.user_api.exception.AppException;
import com.example.user_api.model.UserInfomation;
import com.example.user_api.repository.UserInformationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserInformationServiceTest {
    @Mock
    UserInformationRepository userInformationRepository;
    @InjectMocks
    UserInformationService userInformationService;

    @Test
    public void shouldBeOKWhenGetUserInformation() throws AppException {
        String referenceCode = "199010210344";
        Mockito.when(userInformationRepository.findAllByReferenceCode(referenceCode)).thenReturn(mockUser());
        List<UserInformationResponse> user = userInformationService.getUserByReferenceCode(referenceCode);

        assertNotNull(user.get(0).getUsername());
        assertNotNull(user.get(0).getDateOfBirth());
        assertNotNull(user.get(0).getPhone());
        assertNotNull(user.get(0).getSalary());
    }

    private List<UserInfomation> mockUser(){
        UserInfomation user = new UserInfomation();
        user.setId(123456);
        user.setUsername("tester");
        user.setDateOfBirth(new Date());
        user.setPhone("0879130344");
        user.setSalary(18000);

        List<UserInfomation> userList = new ArrayList<>();
        userList.add(user);

        return userList;
    }

}
