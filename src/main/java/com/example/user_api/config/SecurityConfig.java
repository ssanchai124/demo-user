package com.example.user_api.config;

import javax.servlet.http.HttpServletResponse;

import com.example.user_api.security.CustomUserDetailsService;
import com.example.user_api.security.JWTAuthenticationFiltter;
import com.example.user_api.security.JWTAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomUserDetailsService customUserDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public SecurityConfig(CustomUserDetailsService customUserDetailsService,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.customUserDetailsService = customUserDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/auth/register").permitAll()
				.antMatchers("/user/*").permitAll()
				.and().exceptionHandling()
				.authenticationEntryPoint((req, res, error) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
				.addFilter(authenticationFilter()).sessionManagement().and()
				.addFilter(new JWTAuthorizationFilter(authenticationManager())).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	UsernamePasswordAuthenticationFilter authenticationFilter() throws Exception {
		final UsernamePasswordAuthenticationFilter filter = new JWTAuthenticationFiltter(authenticationManager());
		filter.setAuthenticationManager(authenticationManager());
		return filter;
	}
}
