package com.Security_Agency.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/*@Configuration
public class SecurityConfig {

    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/api/revenue", "/api/employees", "/api/contracts", "/api/services").permitAll() // Public access
                        .requestMatchers("/api/employees/create").hasRole("ADMIN") // Only admin can create employees
                        .requestMatchers("/api/employees/edit/**").hasRole("ADMIN") // Only admin can edit employees
                        .requestMatchers("/api/employees/delete/**").hasRole("ADMIN") // Only admin can delete employees
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page if needed
                        .permitAll()
                )
                .logout(logout -> logout.permitAll()); // Enable logout functionality

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() throws Exception {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("password")) // Use a secure password in production
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin")) // Use a secure password in production
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}*/