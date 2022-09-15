package andrea.publics.backend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class HttpSecurityConfig {
    @Bean
    fun ignorePublicResources(): WebSecurityCustomizer = WebSecurityCustomizer { web: WebSecurity ->
        web.ignoring().antMatchers("/static/**")
    }

    @Bean
    fun apiSecurityFilterChain(
        http: HttpSecurity
    ): SecurityFilterChain {
        http.formLogin(Customizer.withDefaults())
            .authorizeRequests()
            .antMatchers("**").permitAll()
            // .antMatchers("/v1/**").authenticated()
        return http.build()
    }
}
