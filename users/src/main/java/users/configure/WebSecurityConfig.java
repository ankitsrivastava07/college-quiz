
package users.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import users.service.UserDetailServiceImpl;

@EnableWebSecurity

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailServiceImpl userDetailSeruviceImpl;

	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

		authenticationManagerBuilder.userDetailsService(userDetailSeruviceImpl);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/quiz-application/login").permitAll()
				.antMatchers(HttpMethod.POST, "//quiz-application/login").permitAll().anyRequest().authenticated();

		http.httpBasic();
		http.cors().disable();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
