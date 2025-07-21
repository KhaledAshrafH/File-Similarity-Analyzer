package com.khalouda.filesimilarity.service;

import com.khalouda.filesimilarity.model.ComparisonResponse;

public interface SimilarityService {
    ComparisonResponse compareFiles();
    ComparisonResponse getTopMatches(int topN);
}
