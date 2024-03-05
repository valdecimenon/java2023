package com.softgraf.primavera.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigJDBC {

	@Bean
	public PasswordEncoder delegateEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	// permite salvar novos usuários ou apenas retornas os existentes do banco de dados
	@Bean
	public UserDetailsManager users(DataSource dataSource) {

		UserDetails user = User.builder()
								.username("valdeci")
								.password(delegateEncoder().encode("softgraf"))
								.roles(RolesConstants.USER)   // ("USER", "ADMIN")
								.build();
		
		UserDetails admin = User.builder()
								.username("menon")
								.password(delegateEncoder().encode("softgraf"))
								.roles(RolesConstants.USER, RolesConstants.ADMIN)  
								.build();
						
		JdbcUserDetailsManager jdbcUsers = new JdbcUserDetailsManager(dataSource);
		
		// salva usuários, porém na segunda vez lançará excessão, por já existir
//		jdbcUsers.createUser(user);
//		jdbcUsers.createUser(admin);
		
		return jdbcUsers;
	}
	
	
	// https://docs.spring.io/spring-security/reference/servlet/architecture.html
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
			// autoriza requisições http
			.authorizeHttpRequests((request) -> request
					
					// endpoints (rotas do controlador) de acesso público
					.requestMatchers("/", "/homepage", "/sobre", "/images/**",
									 "/uploads/**", "/api/**").permitAll()
					
					// somente ADMIN pode excluir (senão erro: type=Forbidden, status=403)
					.requestMatchers("/produto/excluir/**").hasAnyRole("ADMIN")
					
					// todos os demais endpoints devem ser autenticados
					.anyRequest().authenticated()
			)
			
			// define o formulário personalizado de login
			.formLogin(form -> form
					
						// chama o endpoint do controlador
						.loginPage("/login")
						
						// após fazer o login vai para este endpoint
						.defaultSuccessUrl("/produto/gerenciar", true)  // opcional
						.permitAll()
			)
			
			// executa o logout da aplicação e depois chama um endpoint
			.logout(logout -> logout.logoutSuccessUrl("/login"))  // ou /hompage
			
			// podemos também incluir essas opções
			// .invalidateHttpSession(true)
			// .deleteCookies("JESSIONID")
			
			// proteção contra falsificação de solicitação entre site 
			.csrf(csrf -> csrf.disable());
		
		
		return http.build();
	}
	
}
