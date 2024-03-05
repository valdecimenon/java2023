package com.softgraf.primavera.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// https://docs.spring.io/spring-security/reference/servlet/authentication/
// https://docs.spring.io/spring-security/reference/features/authentication/password-storage.html

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfigMemory {

	@Bean
	public UserDetailsService userDatailService() {

		// o encoder padrão é depreciado por não ser considerado seguro para produção,
		// porém aceitável para teste
		// primeiro usuário: enconder NoOpPasswordEncoder - string sem criptografia
		UserDetails user1 = User.withDefaultPasswordEncoder()
								.username("valdeci")
								.password("softgraf")
								.roles("USER")
								.build();
		
		// segundo usuário: idem NoOpPasswordEncoder
		UserDetails user2 = User.builder()
								.username("antonio")
								// noop =  NoOpPasswordEncoder
								.password("{noop}softgraf")
								.roles("USER")
								.build();
		
		// terceiro usuário
		BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder(16); // 128 bits
		String senhaAdmin1 = bcryptEncoder.encode("softgraf");
		
		UserDetails admin1 = User.builder()
								.username("menon")
								.password("{bcrypt}" + senhaAdmin1)
								.roles("ADMIN")
								.build();
		
		
		// quarto usuário
		PasswordEncoder delegateEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String senhaAdmin2 = delegateEncoder.encode("softgraf");
		
		UserDetails admin2 = User.builder()
							.username("softgraf")
							.password(senhaAdmin2)
							.roles("ADMIN")
							.build();
		
		return new InMemoryUserDetailsManager(user1, user2, admin1, admin2);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((request) -> request
					.anyRequest().authenticated()
			)
			.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/homepage", true)  // opcional
						.permitAll()
			);
		
		return http.build();
	}

}
