package com.thoughtmechanix.authentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
        @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

   @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("john.carnell").password("password1").roles("USER")
                .and()
                .withUser("william.woodward").password("password2").roles("USER", "ADMIN");
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", 
        		"/swagger-resources", "/configuration/security", 
        		"/swagger-ui.html", "/webjars/**", "*swagger*");
    }
    
    
    
    
    
    /**
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
           .authorizeRequests()
           .antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll();
    }
    
    */
    
    
    
    
    
}
