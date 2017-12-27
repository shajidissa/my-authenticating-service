package com.thoughtmechanix.authentication.security;


import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception{
        
    	// http.authenticationProvider(new AnonymousAuthenticationProvider("default"));
    	 
    	/*
    	http
        .authorizeRequests()
          .antMatchers(HttpMethod.DELETE, "/v1/organizations/**")
          .hasRole("ADMIN")
          .anyRequest()
          .authenticated();
        */
        
    	/**
    	http
    	.anonymous().and()
    	.authorizeRequests()
        .antMatchers("swagger-ui.html").permitAll()
        .antMatchers("/swagger-ui.html").permitAll()
        .antMatchers("/swagger-ui.html").permitAll()
        .antMatchers("/swagger-ui.html").permitAll()
        .antMatchers("swagger*").permitAll()
        .antMatchers("swagger").permitAll();*/
        //.anyRequest().permitAll();
        
    	/*
    	 http
         .anonymous()
             .authorities("ROLE_ANONYMOUS")
             .and()
         .authorizeRequests()
             .antMatchers("/").permitAll()
             .antMatchers("/swagger-ui.html").permitAll()
             .antMatchers("/swagger-ui.html").permitAll()
             .antMatchers("*swagger*").permitAll()
             .antMatchers(HttpMethod.GET, "/login/**").permitAll()
             .anyRequest().authenticated();
    
    	
    	*/
    	http
        .authorizeRequests()
        .antMatchers("/swagger-ui.html").access("hasAuthority('ROLE_USER')")
        .anyRequest().fullyAuthenticated();
    	
    	//http.authorizeRequests().antMatchers("/swagger-ui.html", "swagger-ui.html").anonymous().anyRequest().authenticated();
    }
    
   
}
