package com.example.user_api.controller.api;

import com.example.user_api.constant.ResultConstant;
import com.example.user_api.controller.request.UserInformationRequest;
import com.example.user_api.controller.response.GeneralResponse;
import com.example.user_api.controller.response.ResultResponse;
import com.example.user_api.controller.response.UserInformationResponse;
import com.example.user_api.controller.response.UserRegisterResponse;
import com.example.user_api.exception.AppException;
import com.example.user_api.service.UserInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserInformationController {

	@Autowired
	UserInformationService userInformationService;

	@PostMapping(value="/register")
	public ResponseEntity<GeneralResponse<UserRegisterResponse>> createUser(
			@RequestBody @Valid UserInformationRequest req) {
		GeneralResponse<UserRegisterResponse> resp = new GeneralResponse<>();
		log.info("Start get req = {}", req.toString());
		try {
			resp.setData(userInformationService.createUser(req));
			resp.setResult(new ArrayList<>());
			resp.getResult().add(
					ResultResponse.builder()
							.code(ResultConstant.OK)
							.message(ResultConstant.SUCCESS)
							.build());
			return ResponseEntity.ok(resp);
		} catch (AppException | TransactionException e) {
			Integer code = ResultConstant.GENERAL_ERROR_CODE;
			if(e.getMessage().equals(ResultConstant.SALARY_ERROR_MSG)){
				code = ResultConstant.NOT_ACCEPTABLE;
			}
			resp.setResult(new ArrayList<>());
			resp.getResult().add(ResultResponse.builder()
					.code(code)
					.message(e.getMessage())
					.build());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
		}
	}

	@GetMapping(value= "/information/{referenceCode}")
	public ResponseEntity<GeneralResponse<ArrayList<UserInformationResponse>>> getUserByReferenceCode(
			@PathVariable(name="referenceCode") String referenceCode) {
		GeneralResponse<ArrayList<UserInformationResponse>> resp = new GeneralResponse<>();
		try {
			resp.setData(new ArrayList(userInformationService.getUserByReferenceCode(referenceCode)));
			resp.setResult(new ArrayList<>());
			resp.getResult().add(
					ResultResponse.builder()
							.code(ResultConstant.OK)
							.message(ResultConstant.SUCCESS)
							.build());
			return ResponseEntity.ok(resp);
		} catch (com.example.user_api.exception.AppException e) {
			resp.setResult(new ArrayList<>());
			resp.getResult().add(
					ResultResponse.builder()
							.code(ResultConstant.GENERAL_ERROR_CODE)
							.message(e.getMessage())
							.build());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
		}
	}


}



