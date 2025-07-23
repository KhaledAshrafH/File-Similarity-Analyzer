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
    private int maxSizeMb;

    public long getMaxSizeInBytes() {
        return maxSizeMb * 1024L * 1024L;
    }
}
