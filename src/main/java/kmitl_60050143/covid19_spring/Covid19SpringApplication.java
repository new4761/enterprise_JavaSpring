package kmitl_60050143.covid19_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


//Servlet scan For teaching Only not using
@ServletComponentScan
@SpringBootApplication
public class Covid19SpringApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder application) {
        return application.sources(Covid19SpringApplication.class);
    }

    public static void main (String[] args) {
        SpringApplication.run(Covid19SpringApplication.class, args);
    }

    // use Bean RestTemplate module
    @Bean
    public RestTemplate restTemplate (RestTemplateBuilder builder) {
        return builder.build();
    }
}
