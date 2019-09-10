package ru.gdim.simple_java_rest_api.infrastructure.definition;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public final class HttpClientConfig {
    @Bean
    OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }
}
