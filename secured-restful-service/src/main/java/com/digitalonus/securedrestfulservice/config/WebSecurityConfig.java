/**
 *
 * @author Armando Montoya
 * @email armando.montoya@digitalonus.com
 * @Date Apr 24, 2020
 *
 */
package com.digitalonus.securedrestfulservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.microsoft.azure.spring.autoconfigure.aad.AADAppRoleStatelessAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AADAppRoleStatelessAuthenticationFilter aadAuthFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**", "/", "/index.html", "/public").permitAll().anyRequest().authenticated();
		
		http.addFilterBefore(aadAuthFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
