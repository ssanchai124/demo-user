package com.example.user_api.security;

public interface SecurityConstants {
	String SECRET_KEY = "iBlurBlurDevJWS";
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_AUTHORIZATION = "Authorization";
	String CLAIMS_ROLE = "role";
	long EXPIRATION_TIME = (2 * 120 * 1000);
}
