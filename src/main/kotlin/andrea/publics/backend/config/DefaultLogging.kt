package andrea.publics.backend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CommonsRequestLoggingFilter
import javax.servlet.http.HttpServletRequest


@Configuration
class DefaultLogging {


    @Bean("CommonsRequestLoggingFilter")
    fun logFilter(): CommonsRequestLoggingFilter {
        val filter = TestLoggingFilter()
        filter.setIncludeQueryString(true)
        filter.setIncludePayload(true)
        filter.setMaxPayloadLength(10000)
        filter.setIncludeHeaders(true)
        return filter
    }
}


class TestLoggingFilter : CommonsRequestLoggingFilter() {
    override fun afterRequest(request: HttpServletRequest, message: String) =  Unit
}
