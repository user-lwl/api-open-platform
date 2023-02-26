package com.lwl.lwlapiclientsdk;

import com.lwl.lwlapiclientsdk.client.LwlapiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author user-lwl
 * @createDate 2023/2/22 20:38
 */
@Configuration
@ConfigurationProperties("lwlapi.client")
@Data
@ComponentScan
public class LwlApiClientConfig {
    private String accessKey;

    private String secretKey;

    @Bean
    public LwlapiClient lwlapiClient() {
        return new LwlapiClient(accessKey, secretKey);
    }
}
