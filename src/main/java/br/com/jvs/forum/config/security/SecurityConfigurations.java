package br.com.jvs.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.jvs.forum.repository.UsuarioRepository;
import br.com.jvs.forum.service.TokenService;

@EnableWebSecurity
@Configuration
@Profile("prod")
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

		@Autowired
		private AutenticacaoService autenticacaoService;
		
		@Autowired
		private TokenService tokenService;
		
		@Autowired
		private UsuarioRepository repository;
		
		@Override
		@Bean
		protected AuthenticationManager authenticationManager() throws Exception {

			return super.authenticationManager();
		}
	
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// serve para configurações de autenticacao (ex: login)
			auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//configuração de autorização (ex: url)
		
			http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/topicos").permitAll() //permite os métodos GET
			.antMatchers(HttpMethod.GET,"/topicos/*").permitAll()
			.antMatchers(HttpMethod.POST,"/auth").permitAll()
			.antMatchers(HttpMethod.GET,"/actuator/**").permitAll()
			.antMatchers(HttpMethod.DELETE,"/topicos/*").hasRole("MODERADOR")
			.anyRequest().authenticated()
			.and().csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //configuração para não criar sessão
			.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, repository), UsernamePasswordAuthenticationFilter.class);
		}

		@Override
		public void configure(WebSecurity web) throws Exception {
			//configurações de recursos estaticos(ex: css, js, iamgens)
//			web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
		}
		
}
