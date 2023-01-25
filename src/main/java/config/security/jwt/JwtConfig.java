package config.security.jwt;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class JwtConfig {
    @Value("${jwt.key}")
    private String key;
    @Value("${jwt.duration-min}")
    private int durationMin;
}