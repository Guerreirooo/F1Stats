package pt.f1stats.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClient {

    @Bean
    public org.springframework.web.client.RestClient jolpicaRestClient(@Value("${jolpica.api.base-url}") String baseUrl) {
        return org.springframework.web.client.RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

}
