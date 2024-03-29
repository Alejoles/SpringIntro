package com.example.demo.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
          // Whitelist some pages to everyone in those pages isn't necessary to log in
          .antMatchers("/", "index", "/css/*", "/js/*")
          .permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();
    }

}
