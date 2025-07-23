package com.khalouda.filesimilarity.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SimilarityResult  implements Comparable<SimilarityResult>{
    private String fileName;
    private double score;
    private int matchedWords;
    private int totalReferenceWords;
    private String similarityPercentage;

    @Override
    public int compareTo(SimilarityResult similarityResult) {
        return Double.compare(similarityResult.score, this.score);
    }
}
