package com.regionalizacion.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsServiceImpl userDatailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDatailsService).passwordEncoder(passwordEncoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(
				"/",
				"/login",
				"/fonts/**",
				"/js/**",
				"/css/**",
				"/img/**",
				"/js/bootstrap/**").permitAll()
		.antMatchers("/menu/usuarios/**",
					"/menu/regionales/**",
					"/menu/facultades/listar",
					"/menu/facultades/crud",
					"/menu/facultades/eliminar/**",
					"/menu/programas/crud",
					"/menu/programas/eliminar/**",
					"/menu/estudiantes/Consolidado/listar",
					"/menu/docentes/crud",
					"/menu/docentes/eliminar/**",
					"/excel/**"
					).hasAnyAuthority("ROLE_ADMIN")

		.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login")
			.defaultSuccessUrl("/menu/index?ingreso=true",true).failureUrl("/login?error=true")
			.loginProcessingUrl("/menu/usuario/login-ingresar").permitAll()
		.and()
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			//.logoutUrl("/logout")
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout")
			.permitAll();
		
		
	}
	
}
