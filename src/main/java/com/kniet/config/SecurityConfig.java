package com.kniet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private DataSource securityDataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(configurer ->
                        configurer
                                .antMatchers("/AdminPanel/**").hasAnyRole("ADMIN")
                                .antMatchers("/HomePage/**").hasAnyRole("USER")
                                .antMatchers("/resources/**").permitAll()
                                .and())
                                .formLogin(configurer ->
                                        configurer
                                                .loginPage("/showLoginPage")
                                                .loginProcessingUrl("/authenticateTheUser").permitAll())
                .logout().permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
                .and()
                .build();
    }

    @Autowired
    protected void configAuthentication(AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager.jdbcAuthentication().dataSource(securityDataSource)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(securityDataSource);
        return jdbcUserDetailsManager;
    }

}
