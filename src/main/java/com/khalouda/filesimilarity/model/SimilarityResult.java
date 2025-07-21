package com.khalouda.filesimilarity.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SimilarityResult  implements Comparable<SimilarityResult>{
    private String fileName;
    private double similarityScore;
    private int matchedWords;
    private int totalReferenceWords;

    @Override
   public int compareTo(SimilarityResult other) {
        return Double.compare(other.similarityScore, this.similarityScore);
    }
}
