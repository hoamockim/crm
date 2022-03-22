package com.tipee.crm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties
@PropertySource(value = "classpath:system_code.yml", factory = YamlPropertySourceFactory.class)
public class SystemCodes {
    
}
