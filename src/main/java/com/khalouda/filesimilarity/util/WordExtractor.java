package com.khalouda.filesimilarity.util;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

@Component
public class WordExtractor {
    private static final String WORD_REGEX="[^a-zA-Z]+";

    public Set<String> extractWords(String text) {
        if (text==null||text.isEmpty())
            return Set.of();
        Pattern pattern = Pattern.compile(WORD_REGEX);

        Set<String> result = new HashSet<>();
        String lowerCaseOfText=text.toLowerCase();
        String[]words=pattern.split(lowerCaseOfText);
        for (String word:words) {
            if (!word.isEmpty()) {
                if (word.length() > 1)
                    result.add(word);
            }
        }
        return result;
    }

    public double calculateSimilarity(Set<String> referenceWords, Set<String> targetWords) {
        if (referenceWords.isEmpty()) {
            return targetWords.isEmpty()?100.0:0.0;
        }

        long cnt=0;
        for (String word:referenceWords)
            if (targetWords.contains(word))
                cnt++;
        return (double)(cnt/referenceWords.size())*100.0;
    }
}
