package com.khalouda.filesimilarity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class FileSimilarityAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileSimilarityAnalyzerApplication.class, args);
    }

}
