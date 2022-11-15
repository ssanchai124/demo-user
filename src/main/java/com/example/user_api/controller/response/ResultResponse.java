package com.example.user_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse implements Serializable {
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;
}