package org.foxconn.config;

import javax.annotation.Resource;

import org.foxconn.filter.JWTAuthenticationFilter;
import org.foxconn.filter.JWTLoginFilter;
import org.foxconn.service.UserService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月13日 下午5:35:48
*/
@Configuration  
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)  
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {  
  
	@Resource
    private UserDetailsService userDetailsService;  
	
	@Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;  
  
    public WebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {  
        this.userDetailsService = userDetailsService;  
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;  
    }  
  
    @Override  
    protected void configure(HttpSecurity http) throws Exception {  
        http.cors().and().csrf().disable().authorizeRequests()  
                .antMatchers(HttpMethod.POST, "/**","/users/signup").permitAll()  
                .antMatchers(HttpMethod.GET, "/**","/services/**", "/rabbit/**", "/users/**").permitAll()  
                .anyRequest().authenticated()  
                .and()  
                .addFilter(new JWTLoginFilter(authenticationManager()))  
                .addFilter(new JWTAuthenticationFilter(authenticationManager()));  
    }  
  
    @Override  
    public void configure(AuthenticationManagerBuilder auth) throws Exception {  
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);  
    }  
  
}  