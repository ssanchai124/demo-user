package com.example.user_api.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;

//@Configuration
//@Scope("prototype")
public class DateUtils {
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public DateUtils() {
		System.out.println("object created");
	}

	@Bean
	public String todayString() {
		return simpleDateFormat.format(new Date());
	}

	@PostConstruct
	public void init() throws Exception {
		System.out.println("object init");
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("object destroy");
	}


}
