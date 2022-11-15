package com.example.user_api.service;

import com.example.user_api.constant.Constant;
import com.example.user_api.constant.ResultConstant;
import com.example.user_api.controller.request.UserInformationRequest;
import com.example.user_api.controller.response.UserInformationResponse;
import com.example.user_api.controller.response.UserRegisterResponse;
import com.example.user_api.exception.AppException;
import com.example.user_api.model.UserInfomation;
import com.example.user_api.repository.UserInformationRepository;
import com.example.user_api.util.DateConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserInformationService {

	@Autowired
	UserInformationRepository userRepository;

	//CREATE
	@Transactional
	public UserRegisterResponse createUser(UserInformationRequest req) throws AppException {
		log.info("Start saving user = {}", req.toString());
		try {
			UserRegisterResponse registerResponse = new UserRegisterResponse();
			int salary = Integer.parseInt(req.getSalary());
			if( salary > Constant.PLATINUM_SALARY) {
				req.setMemberType(Constant.PLATINUM);
			}else if(salary > Constant.GOLD_OVER_SALARY && salary < Constant.GOLD_LESS_SALARY) {
				req.setMemberType(Constant.GOLD);
			}else if(salary > Constant.SILVER_SALARY){
				req.setMemberType(Constant.SILVER);

			}else if(salary < Constant.REJECT_SALARY){
				throw new AppException(ResultConstant.SALARY_ERROR_MSG);
			}

			Date dateOfBirth = DateConvertUtils.convertDate(req.getDateOfBirth());
			log.info("dateOfBirth = {} ,{} ", req.getDateOfBirth() ,dateOfBirth);

			String dateFormat = DateConvertUtils.convertStr(dateOfBirth);

			String lastDigits = req.getPhone().substring(req.getPhone().length() - 4);
			String ReferenceCode = dateFormat+lastDigits;

			req.setReferenceCode(ReferenceCode);

			UserInfomation user;
			user = toUser(req);
			log.info("End saving user = {}", user);

			UserInfomation userById = userRepository.saveAndFlush(user);
			log.info("End saving userById = {}", userById);

			registerResponse.setReferenceCode(userById.getReferenceCode());

			return registerResponse;
		} catch (DataAccessException | HibernateException e) {
			throw new AppException(e.getMessage(), e);
		}
	}

	//READ
	public List<UserInformationResponse> getUserByReferenceCode(final String referenceCode) throws AppException {
		log.info("Start get user = {}", referenceCode);
		try {
			List<UserInformationResponse> userResponse = new ArrayList<>();
			if (referenceCode != null) {
				List<UserInfomation> users = userRepository.findAllByReferenceCode(referenceCode);
				if (!users.isEmpty()) {
					users.forEach(user -> userResponse.add(toUserResponse(user)));
				}
			}
			log.info("End get user = {}", userResponse);
			return userResponse;
		} catch (DataAccessException | HibernateException e) {
			throw new com.example.user_api.exception.AppException(e.getMessage(), e);
		}

	}

	private UserInformationResponse toUserResponse(final UserInfomation user){
		return UserInformationResponse.builder()
				.id(user.getId())
				.username(user.getUsername())
				.phone(user.getPhone())
				.dateOfBirth(user.getDateOfBirth())
				.salary(user.getSalary())
				.memberType(user.getMemberType())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.address(user.getAddress())
				.subDistrict(user.getSubDistrict())
				.district(user.getDistrict())
				.province(user.getProvince())
				.zipcode(user.getZipcode())
				.build();
	}

	private UserInfomation toUser(final UserInformationRequest request) {
		return new UserInfomation(request.getId(),
				request.getUsername(),
				request.getPassword(),
				request.getPhone(),
				DateConvertUtils.convertDate(request.getDateOfBirth()),
				Integer.parseInt(request.getSalary()),
				request.getReferenceCode(),
				request.getMemberType(),
				request.getFirstName(),
				request.getLastName(),
				request.getAddress(),
				request.getSubDistrict(),
				request.getDistrict(),
				request.getProvince(),
				request.getZipcode()
		);
	}
}

