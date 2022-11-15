package com.example.user_api.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_info")
@SuppressWarnings("serial")
public class UserInfomation implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private int id;

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="phone")
	private String phone;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name="salary")
	private Integer salary;

	@Column(name="reference_code")
	private String referenceCode;

	@Column(name="member_type")
	private String memberType;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="address")
	private String address;

	@Column(name="district")
	private String district;

	@Column(name="sub_district")
	private String subDistrict;

	@Column(name="province")
	private String province;

	@Column(name="zipcode")
	private Integer zipcode;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + username + '\'' +
				", password='" + password + '\'' +
				", phone='" + phone + '\'' +
				", dateOfBirth=" + dateOfBirth +
				", salary=" + salary +
				", referenceCode='" + referenceCode + '\'' +
				", memberType='" + memberType + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address='" + address + '\'' +
				", district='" + district + '\'' +
				", subDistrict='" + subDistrict + '\'' +
				", province='" + province + '\'' +
				", zipcode=" + zipcode +
				'}';
	}
}
