package com.khalouda.filesimilarity.service.impl;

import com.khalouda.filesimilarity.config.ApplicationConfig;
import com.khalouda.filesimilarity.model.ComparisonResponse;
import com.khalouda.filesimilarity.model.FileContent;
import com.khalouda.filesimilarity.model.SimilarityResult;
import com.khalouda.filesimilarity.service.FileReaderService;
import com.khalouda.filesimilarity.service.SimilarityService;
import com.khalouda.filesimilarity.util.WordExtractor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimilarityServiceImpl implements SimilarityService {
    private final FileReaderService fileReaderService;
    private final WordExtractor wordExtractor;
    private final ApplicationConfig appConfig;

    @Override
    public ComparisonResponse compareFiles() {
        long startTime = System.currentTimeMillis();

        log.info("Starting comparison process...");
        FileContent referenceFile = fileReaderService.readFile(appConfig.getReferencePath());

        List<String> poolFiles = fileReaderService.getTextFilesInDirectory(appConfig.getPoolDirectory());

        List<SimilarityResult> results = new ArrayList<>();

        for (String poolFilePath : poolFiles) {
            try {
                if (poolFilePath.equals(appConfig.getReferencePath()))
                    continue;

                FileContent poolFile = fileReaderService.readFile(poolFilePath);

                double similarity = wordExtractor.calculateSimilarity(
                        referenceFile.getWords(),
                        poolFile.getWords()
                );

                int matchedWords = (int) referenceFile.getWords().stream()
                        .filter(poolFile.getWords()::contains)
                        .count();

                SimilarityResult result = SimilarityResult.builder()
                        .fileName(poolFile.getFileName())
                        .similarityScore(similarity)
                        .matchedWords(matchedWords)
                        .totalReferenceWords(referenceFile.getTotalWords())
                        .build();

                results.add(result);

            } catch (Exception e) {
                log.error("Error processing file: {}", poolFilePath, e);
            }
        }

        results.sort((a, b) -> Double.compare(b.getSimilarityScore(), a.getSimilarityScore()));

        long executionTime = System.currentTimeMillis() - startTime;

        return ComparisonResponse.builder()
                .referenceFile(referenceFile.getFileName())
                .totalFilesCompared(results.size())
                .results(results)
                .executionTimeMs(executionTime)
                .bestMatch(results.isEmpty() ? "No matches found" : results.get(0).getFileName())
                .build();
    }

    @Override
    public ComparisonResponse getTopMatches(int topN) {
        ComparisonResponse fullResponse = compareFiles();

        List<SimilarityResult> topResults = fullResponse.getResults().stream()
                .limit(topN)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        fullResponse.setResults(topResults);
        return fullResponse;
    }
}
