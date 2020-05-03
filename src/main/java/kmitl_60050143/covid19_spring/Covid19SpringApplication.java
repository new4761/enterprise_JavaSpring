package kmitl_60050143.covid19_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;




@SpringBootApplication(exclude = {SecurityAutoConfiguration.class , UserDetailsServiceAutoConfiguration.class})
@ServletComponentScan
public class Covid19SpringApplication {


    public static void main (String[] args) {
        SpringApplication.run(Covid19SpringApplication.class, args);
    }

    // use Bean RestTemplate module
    @Bean
    public RestTemplate restTemplate (RestTemplateBuilder builder) {
        return builder.build();
    }
}
