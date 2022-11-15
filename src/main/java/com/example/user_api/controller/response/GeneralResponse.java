package com.example.user_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse<T extends Serializable> implements Serializable {
    @JsonProperty("result")
    private ArrayList<com.example.user_api.controller.response.ResultResponse> result;
    @JsonProperty("data")
    private T data;
}