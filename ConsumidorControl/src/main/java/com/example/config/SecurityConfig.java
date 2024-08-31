
package com.example.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 *
 * @author nahue
 */

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll()
                .requestMatchers("/verFormularios/**").hasAnyRole("ADMIN","PROFESOR")
                .requestMatchers("/verTablas/**").hasAnyRole("ADMIN","PROFESOR","QUERY")
                .requestMatchers("/individuos/**").hasRole("ADMIN")
                .requestMatchers("/register").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/images/**").permitAll()
                
                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                .defaultSuccessUrl("/", true) // a donde va cuando hace login
                )
                .logout(config -> config.logoutSuccessUrl("/")) // a donde va cuando cierra login
                .build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); 
    }
    
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No estás autorizado para acceder a esta página");
        };
    }
    
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.addDialect(new SpringSecurityDialect()); // Integración con Spring Security
        return templateEngine;
    }

}