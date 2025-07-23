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

        Set<String> res=new HashSet<>();
        String lowerCaseOfText=text.toLowerCase();
        String[]words=pattern.split(lowerCaseOfText);
        for (String word:words) {
            if (!word.isEmpty()) {
                if (word.length()>1)
                    res.add(word);
            }
        }
        return res;
    }

    public double calculateSimilarity(Set<String> referenceWords, Set<String> targetWords) {
        if (referenceWords.isEmpty())
            return targetWords.isEmpty()?100.0:0.0;

        long cnt=0;
        for (String word:referenceWords) // O(n )
            if (targetWords.contains(word)) // o(1)
                cnt++;
        double res=((double) cnt/referenceWords.size())*100.0;
        return Math.round(res*100.0)/100.0;
    }
}
