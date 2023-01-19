package config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "config.database")
public class DbConfig {
    @Bean
    public EntityManagerFactory entityManagerFactory(@Qualifier("dialect") String dialect, DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("model");
        factory.setJpaProperties(additionalProperties(dialect));
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    private Properties additionalProperties(String dialect) {
        Properties properties = new Properties();

        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.format_sql", "true");

        return properties;
    }
}
