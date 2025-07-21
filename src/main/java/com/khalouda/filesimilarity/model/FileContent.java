package com.khalouda.filesimilarity.model;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FileContent {
    private String fileName;
    private String filePath;
    private Set<String> words;
    private int totalWords;

    public boolean hasWords() {
        return words != null && !words.isEmpty();
    }
}
