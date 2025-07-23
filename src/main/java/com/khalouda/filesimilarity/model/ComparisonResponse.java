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
    private String executionTime;
    private String bestMatch;
}
