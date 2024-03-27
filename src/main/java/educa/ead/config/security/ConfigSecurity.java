package educa.ead.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class ConfigSecurity {

	@Autowired

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	
		
		http.csrf(csrf->{
			csrf.disable();
		});
		http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
		.authorizeHttpRequests(auth-> auth.requestMatchers("**static/**").permitAll())
		.authorizeHttpRequests(auth-> auth.requestMatchers("/**").permitAll())
		.authorizeHttpRequests(auth-> auth.requestMatchers( "/aluno/**").permitAll())
		.authorizeHttpRequests(auth-> auth.requestMatchers( "/professor/**").permitAll())

		.authorizeHttpRequests(auth-> auth.anyRequest().authenticated())
		
		.formLogin((formlogin->{
			formlogin.permitAll().loginPage("/login").permitAll().defaultSuccessUrl("/home").failureUrl("/login?error=true");
			
		})).logout((logout->{
			logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
		}));
		

		return http.build();
		


	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("**static/**");
	}

	

}