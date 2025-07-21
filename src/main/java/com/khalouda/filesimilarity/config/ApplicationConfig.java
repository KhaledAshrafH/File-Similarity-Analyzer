package com.khalouda.filesimilarity.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.file")
public class ApplicationConfig {
    private String referencePath;
    private String poolDirectory;
    final private int MAX_SIZE_IN_MB = 5;

    public long getMaxSizeBytes() {
        return MAX_SIZE_IN_MB * 1024L * 1024L;
    }
}
