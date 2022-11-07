package Candela_Grosso.Centro_medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/index").hasRole("USER")
                .antMatchers("/nuevo_medico.html").hasRole("ADMIN")
                .antMatchers("/actualizar_medico.html").hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/index")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf()
                .disable();
                http.headers().frameOptions().and().contentSecurityPolicy("frame-ancestors 'self' https://javabydeveloper.com hhtps://*.javabydeveloper.com").and().and();
    }

}