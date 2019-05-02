package com.platzi.ereservation.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Class to configure security
 * @author Camilo Valenzuela
 *
 */
@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter{
	
	/**
	 * Method with authentication basic
	 */
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.httpBasic();
	}
	
	/**
	 * Method with login page
	 * @param http
	 * @throws Exception
	 
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
			.authorizeRequests().anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/app/login").permitAll()
				.failureUrl("/app/login?error=true")
				.defaultSuccessUrl("/app/home");
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	auth.inMemoryAuthentication().withUser("camilo").password(encoder.encode("camilo")).roles("USER");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
	*/
}
