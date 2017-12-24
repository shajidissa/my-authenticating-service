package com.thoughtmechanix.authentication.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

//private String allowOrigin= "http://localhost:8085";
	
// https://github.com/spring-projects/spring-security-oauth/issues/938

@Bean
public FilterRegistrationBean corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    
    CorsConfiguration configAutenticacao = new CorsConfiguration();
    configAutenticacao.setAllowCredentials(true);
    //configAutenticacao.addAllowedOrigin(allowOrigin);
    configAutenticacao.addAllowedOrigin("*");  
    configAutenticacao.addAllowedHeader("Authorization");
    configAutenticacao.addAllowedHeader("Content-Type");
    configAutenticacao.addAllowedHeader("Accept");
    //configAutenticacao.setAllowCredentials(true); 
    //configAutenticacao.addAllowedHeader("*");
    configAutenticacao.addAllowedMethod("POST");
    configAutenticacao.addAllowedMethod("GET");
    configAutenticacao.addAllowedMethod("DELETE");
    configAutenticacao.addAllowedMethod("PUT");
    configAutenticacao.addAllowedMethod("OPTIONS");
    configAutenticacao.setMaxAge(3600L);
    // source.registerCorsConfiguration("/oauth/token", configAutenticacao);
    source.registerCorsConfiguration("/**", configAutenticacao); // Global for all paths
    
    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return bean;
}
}
