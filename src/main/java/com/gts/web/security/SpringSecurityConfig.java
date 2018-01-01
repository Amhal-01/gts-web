package com.gts.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.gts.web.services.UtilisateurS;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AccessDeniedHandler accessDeniedHandler;
	@Autowired
	UtilisateurS service;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
			.antMatchers("/**").permitAll()
			.antMatchers(
					"/banques/**","/buss/**","/chauffeurs/**",
					"/cheques/**","/ecoles/**","/paiements/**",
					"/respEcoles/**","/itineraires/**",
					"/utilisateurs/**"
					)
			.hasAnyRole("ADMIN")
			.antMatchers(
					"/etudiants/**","/itineraires/**","/pointDeRamassages/**",
					"/voyages/**","/buss/**","/profile","/logout"
					)
			.hasAnyRole("USER","ADMIN")
			.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").permitAll()
				.failureUrl("/login?error")
				.defaultSuccessUrl("/home")
				.usernameParameter("email")
			.and()
				.logout()
				.logoutSuccessUrl("/")
				.permitAll()
			.and()
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}
	/*
	@Autowired
	public void configureJpaBasedUsers(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);
	}
	
	*/
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("a@a.a")
			.password("1234")
			.roles("ADMIN");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**");
	}
}
