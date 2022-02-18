package cute.dundun.common.configuration;

import cute.dundun.common.filter.RequestIdFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebFluxWebConfiguration implements WebFluxConfigurer {
    @Bean
    public RequestIdFilter requestIdFilter() {
        return new RequestIdFilter();
    }




}
