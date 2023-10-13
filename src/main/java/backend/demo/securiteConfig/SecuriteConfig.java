package backend.demo.securiteConfig;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecuriteConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()

                .and()
                .authorizeRequests()
                .antMatchers("/api/**")
                .hasRole("USER")
                .antMatchers("/**")
                .hasRole("ADMIN").and()
                .csrf().disable().cors().disable().headers()
                .frameOptions().disable();
    }

    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(
                        NoOpPasswordEncoder.getInstance())
                .withUser("user").password("password1")
                .roles("USER").and().withUser("admin").password("password2")
                .roles("USER", "ADMIN");

    }

    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry corsRegistry) {
            corsRegistry.addMapping("/**")
                    .allowedOrigins("http://localhost:63767")
                    .allowedMethods("*")
                    .maxAge(3600L)
                    .allowedHeaders("*")
                    .exposedHeaders("Authorization")
                    .allowCredentials(true);
        }
    }
}
