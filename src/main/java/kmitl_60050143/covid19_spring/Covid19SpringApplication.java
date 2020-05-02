package kmitl_60050143.covid19_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



//Servlet scan For teaching Only not using

@SpringBootApplication(exclude = SecurityAutoConfiguration.class )
public class Covid19SpringApplication  {


    public static void main (String[] args) {
        SpringApplication.run(Covid19SpringApplication.class, args);
    }

    // use Bean RestTemplate module
    @Bean
    public RestTemplate restTemplate (RestTemplateBuilder builder) {
        return builder.build();
    }
}
