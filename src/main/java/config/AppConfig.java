package config;

import client.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.text.DateFormat;
import java.util.Date;

@Configuration
@PropertySource("classpath:client.property")
public class AppConfig {

    @Value("${id}")
    private int id;

    @Value("${fullName}")
    private String fullName;

    @Bean
    public Client client() {
        Client client = new Client(id,fullName);
        return client;
    }

    @Bean
    public Date newDate() {
        return new Date();
    }

    @Bean
    public DateFormat dateFormat() {
        return DateFormat.getDateTimeInstance();
    }



}
