//package com.blogs.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.security.web.SecurityFilterChain;
//import com.blogs.security.CustomJWTAuthenticationFilter;
//
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    private final CustomJWTAuthenticationFilter customJWTAuthenticationFilter;
//
//    // Constructor injection
//    public SecurityConfiguration(CustomJWTAuthenticationFilter customJWTAuthenticationFilter) {
//        this.customJWTAuthenticationFilter = customJWTAuthenticationFilter;
//    }
//
//    @Bean
//    public SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//            .cors(cors -> cors.configurationSource(corsConfigurationSource())) // ✅ Enable CORS in Security
//            .authorizeHttpRequests(request ->      
//                request.requestMatchers(
//                        "/auth/login", "/auth/Register",
//                        "/v*/api-doc*/**", "/swagger-ui/**").permitAll()
//                .requestMatchers(HttpMethod.OPTIONS).permitAll()
//                .requestMatchers("/api/customers/**").hasRole("CUSTOMER")
//                .requestMatchers("/api/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//            )
//            .sessionManagement(session -> 
//                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        // Add CustomJWTAuthenticationFilter to the filter chain
//        http.addFilterBefore(customJWTAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("http://localhost:3000")); // ✅ Allow frontend requests
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(List.of("*"));
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}
