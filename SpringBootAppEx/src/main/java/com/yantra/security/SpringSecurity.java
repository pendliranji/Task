package com.yantra.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurity extends WebSecurityConfigurerAdapter {


	@Autowired
	private DataSource ds;

	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource ds() {
		return DataSourceBuilder.create().build();
	}

	@Autowired
	public void configureAMBuilder(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds)
		.authoritiesByUsernameQuery("select email, role FROM USERS where email=?")
		.usersByUsernameQuery("select email,userPassword FROM USERS where email=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.anyRequest().authenticated();
		http.csrf().disable();
	}



}
