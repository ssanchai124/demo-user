package com.example.user_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInformationResponse implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @JsonProperty("salary")
    private Integer salary;

    @JsonProperty("memberType")
    private String memberType;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("district")
    private String district;

    @JsonProperty("subDistrict")
    private String subDistrict;

    @JsonProperty("province")
    private String province;

    @JsonProperty("zipcode")
    private Integer zipcode;
}
