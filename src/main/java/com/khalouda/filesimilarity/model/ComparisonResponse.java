package com.khalouda.filesimilarity.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ComparisonResponse {
    private String referenceFile;
    private int totalFilesCompared;
    private List<SimilarityResult> results;
    private long executionTimeMs;
    private String bestMatch;

    public boolean hasResults() {
        return results != null && !results.isEmpty();
    }
}
