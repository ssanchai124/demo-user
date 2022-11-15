package com.example.user_api.constant;
public class ResultConstant {
	private ResultConstant(){
		throw new IllegalStateException("ErrorConstant class");
	}

	// Result Code
	public static final Integer OK = 200;
	public static final Integer BAD_REQUEST = 400;
	public static final Integer UNAUTHORIZED = 401;
	public static final Integer NOT_FOUND = 404;
	public static final Integer NOT_ACCEPTABLE = 406;
	public static final Integer CONFLICT = 409;
	public static final Integer GENERAL_ERROR_CODE = 500;
	public static final String SALARY_ERROR_MSG = "Salary has less than 15000 baht";
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
}
