//package com.ccanoprojects.aldeas.configure;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//	
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/client");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/css/*", "/img/*").permitAll().anyRequest().authenticated()
//			.and().formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
//				.usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/loginsuccess").permitAll()
//				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll();
//		
//		super.configure(http);
//	}
//	
//}
