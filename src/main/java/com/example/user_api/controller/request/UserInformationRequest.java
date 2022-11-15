package com.example.user_api.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NotNull
public class UserInformationRequest implements Serializable {

    private int id;

    @NotNull(message = "username cannot be null !")
    @NotEmpty(message = "username cannot be empty !")
    private String username;

    @NotNull(message = "password cannot be null !")
    @NotEmpty(message = "password cannot be empty !")
    private String password;

    @NotNull(message = "phone cannot be null !")
    @NotEmpty(message = "phone cannot be empty !")
    private String phone;

    @NotNull(message = "birthDate cannot be null !")
    @NotEmpty(message = "birthDate cannot be empty !")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String dateOfBirth;

    @NotNull(message = "salary cannot be null !")
    @NotEmpty(message = "salary cannot be empty !")
    private String salary;

    private String referenceCode;

    private String memberType;

    private String firstName;

    private String lastName;

    private String address;

    private String district;

    private String subDistrict;

    private String province;

    private Integer zipcode;


}
