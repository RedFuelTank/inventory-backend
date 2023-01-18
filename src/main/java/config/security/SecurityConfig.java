package config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@PropertySource("classpath:/application.properties")
public class SecurityConfig {
    private static final int ENCRYPTION_STRENGTH = 10;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin();

        http.authorizeHttpRequests()
                .requestMatchers("/hello").permitAll()
                .anyRequest().authenticated();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("$2a$10$pGghX8RhquNfWDaLXzoREuQmVmjzTpa3dJP2sG9iTlHGHRwwU5Fty")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("$2a$10$kuRPi3Z/QZ3m/jbNzSaRAuWdXQBMNe1ezPFa9VwSI3mF.xSfP0aIC")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(ENCRYPTION_STRENGTH);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(SecurityConfig.ENCRYPTION_STRENGTH);
        String userPassword = encoder.encode("user");
        System.out.printf("User password: %s\n", userPassword);

        String adminPassword = encoder.encode("admin");
        System.out.printf("Admin password: %s\n", adminPassword);
    }
}
