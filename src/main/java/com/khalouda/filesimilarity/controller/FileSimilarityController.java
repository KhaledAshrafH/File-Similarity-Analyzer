package com.khalouda.filesimilarity.controller;

import com.khalouda.filesimilarity.model.ComparisonResponse;
import com.khalouda.filesimilarity.service.SimilarityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/similarity")
@RequiredArgsConstructor
public class FileSimilarityController {

    private final SimilarityService similarityService;

    @GetMapping("/compare")
    public ResponseEntity<ComparisonResponse> compareAllTheFiles() {
        log.info("received request to compare the files");

        ComparisonResponse response = similarityService.compareFiles();

        log.info("comparison completed successfully in {} ms", response.getExecutionTimeMs());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/top/{count}")
    public ResponseEntity<ComparisonResponse> getTopMatches(@PathVariable int count) {
        if (count<=0)
            return ResponseEntity.badRequest().build();

        ComparisonResponse response = similarityService.getTopMatches(count);
        log.info("Top {} Collected Successfully", count);
        return ResponseEntity.ok(response);
    }
}