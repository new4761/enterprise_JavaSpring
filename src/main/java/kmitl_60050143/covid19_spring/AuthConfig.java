package kmitl_60050143.covid19_spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// for handle 403 error
@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.httpBasic();
        http.cors().and().csrf().disable();
      //  super.configure(http);
    }

    @Override
    public void configure (WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/**");
    }
    // for handle 403 error auto auth by default
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("username").password("yourpassword").roles("ADMIN");
    }
}