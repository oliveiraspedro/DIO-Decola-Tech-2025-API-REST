package br.com.dio.dio.Spring.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity // Habilitando uma segurança web de forma manual
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll() // Allow access to the root path
                        .requestMatchers(HttpMethod.POST, "/login").permitAll() // Allow POST requests to /login
                        .requestMatchers("/managers").hasAnyRole("MANAGERS") // Restrict access to /managers
                        .requestMatchers("/users").hasAnyRole("USERS", "MANAGERS") // Restrict access to /users
                        .anyRequest().authenticated() // Require authentication for all other requests
                )
                .formLogin(withDefaults()); // Enable form-based login

        return http.build();
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("{noop}user123")
//                .roles("USERS")
//                .and()
//                .withUser("admin")
//                .password("{noop}master123")
//                .roles("MANAGERS");
//    }
}
