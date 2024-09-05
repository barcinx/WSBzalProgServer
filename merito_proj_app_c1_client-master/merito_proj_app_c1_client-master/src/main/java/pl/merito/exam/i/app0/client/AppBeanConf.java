package pl.merito.exam.i.app0.client;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AppBeanConf {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
