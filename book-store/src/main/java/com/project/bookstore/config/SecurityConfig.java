package com.project.bookstore.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.project.bookstore.config.auth.PrincipalDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true) //자격이 있으면 눌러지게
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	CustomAuthenticationFailureHandler customFailureHandler = new CustomAuthenticationFailureHandler();


	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/adminpage/**").hasAuthority("ROLE_ADMIN")
			.antMatchers("/mypage/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
			.antMatchers("/**").permitAll()
			.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login") // jsp파일의 action과 일치시키기!
				.defaultSuccessUrl("/")
				.failureHandler(customFailureHandler)
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true);
	}
	
	@Override
    // 정적리소스는 권한에 상관없게 설정.
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

}







