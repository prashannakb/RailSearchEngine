package com.rail.search.engine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	public void configureGlobal(@Lazy AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("poiuytr"))
				.authorities("ROLE_ADMIN");
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("asdfghj"))
				.authorities("ROLE_USER");

	}

	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((authz) -> authz.antMatchers("/admin/**").hasRole("ADMIN") .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
		http.authorizeHttpRequests((authz) -> authz.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN").anyRequest().authenticated());

		http.csrf(csrf -> csrf.disable());
		http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}

}
