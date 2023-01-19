package config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class HsqldbConfig {
    @Value("${hsqldb.url}")
    private String url;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl(url);

        return dataSource;
    }

    @Bean("dialect")
    public String dialect() {
        return "org.hibernate.dialect.HSQLDialect";
    }

}
