package br.com.jvs.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Profile("dev")
public class DevSecurityConfigurations extends WebSecurityConfigurerAdapter {

		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//configuração de autorização (ex: url)
		
			http.authorizeRequests()
			.antMatchers("/**").permitAll() //permite os métodos GET
			.and().csrf().disable();
		}

		@Override
		public void configure(WebSecurity web) throws Exception {
			//configurações de recursos estaticos(ex: css, js, iamgens)
//			web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
		}
		
}
