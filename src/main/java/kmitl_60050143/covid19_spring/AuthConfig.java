package kmitl_60050143.covid19_spring;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.requiresChannel()
                .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
                .requiresSecure();
        http.authorizeRequests()
                .antMatchers("/").permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        super.configure(http);
    }

    @Override
    public void configure (WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/**");
    }
}