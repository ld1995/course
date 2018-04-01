package com.example.course.security;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value(value = "${auth0.audience}")
    private String audience;

    @Value(value = "${auth0.issuer}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(audience,issuer)
                .configure(http)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/public/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/public/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/public/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/public/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/private/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/private/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/private/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/private/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/private/user/add").hasAuthority("write:user");
    }

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}

}
