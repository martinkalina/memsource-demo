package cz.mkalina.memsourcedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {


    @Value("${memsource.api.url}")
    private String baseUrl;

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.rootUri(baseUrl).build();
    }

}
