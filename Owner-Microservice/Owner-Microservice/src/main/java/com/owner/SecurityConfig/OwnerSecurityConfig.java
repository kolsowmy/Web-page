package com.owner.SecurityConfig;



import org.apache.hc.core5.reactor.IOReactorService;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;


import org.springframework.security.authentication.AuthenticationManager;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.security.config.annotation.web.builders.WebSecurity;


import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;



import org.springframework.security.crypto.factory.PasswordEncoderFactories;


import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity


public class OwnerSecurityConfig extends WebSecurityConfiguration {


 @Autowired

private OwnerService ownerService;



 protected void configure(AuthenticationManagerBuilder auth) throws Exception {

auth.userDetailsService((UserDetailsService) ownerService);

}


@SuppressWarnings("deprecation")
protected void configure(HttpSecurity http) throws Exception {

http.csrf().disable()

 .authorizeRequests()

.requestMatchers("/owner/addOwner", "/owner/auth")

.permitAll()

 .anyRequest()

.authenticated()

 .and()

.formLogin();

}


@Bean

public PasswordEncoder passwordEncoder() {

return PasswordEncoderFactories.createDelegatingPasswordEncoder();

}


@Bean

 public AuthenticationManager authenticationManagerBean() throws Exception {

	return super.authenticationManagerBean();

}


}






