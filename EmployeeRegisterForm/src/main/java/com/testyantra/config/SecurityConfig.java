package com.testyantra.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource ds;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		System.out.println(ds);
		String sql="select mail,PASSWORD,enabled from employee_tab where mail=?";
		String sql2="select mail,ROLES from employee_roles where mail=?";
	auth.jdbcAuthentication().dataSource(ds).usersByUsernameQuery(sql)
	.authoritiesByUsernameQuery(sql2);
	
	System.out.println(sql+"-----------------------------------------");
	System.out.println(sql2+"-----------------------------------------");
	
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
/*
		http.authorizeRequests().antMatchers("/reg").access("permitAll")
		.antMatchers("/view,/delete,/edit").access("hasAnyRole('ADMIN')").and()
		.formLogin().
		and().
		exceptionHandling().accessDeniedPage("/Failure.jsp")
		.and()
		.logout().logoutSuccessUrl("/Logout.jsp");
		*/
		
		http.authorizeRequests()
		.antMatchers("/reg").permitAll()
 		.antMatchers("/view").hasAnyAuthority("ADMIN","USER")
		.antMatchers("/delete", "/update", "/edit").hasAuthority("ADMIN")
		
		//.anyRequest().authenticated()
		.and().formLogin()
		.defaultSuccessUrl("/reg").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
		.exceptionHandling().accessDeniedPage("/logout");
	
	
	}

}



















