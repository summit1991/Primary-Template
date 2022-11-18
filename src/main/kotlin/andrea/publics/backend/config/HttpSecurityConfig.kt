package andrea.publics.backend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class HttpSecurityConfig {
    @Bean
    fun ignorePublicResources(): WebSecurityCustomizer = WebSecurityCustomizer { web: WebSecurity ->
        web.ignoring().antMatchers("/static/**")
    }

    // 자세한 설정이 위로 와야하는군
    @Bean
    fun apiSecurityFilterChain(
        http: HttpSecurity
    ): SecurityFilterChain {
        http.formLogin(Customizer.withDefaults())
            .authorizeRequests()
            //.antMatchers("/v1/**").authenticated()
            .antMatchers("**").permitAll()
        return http.build()
    }
}
