package com.khalouda.filesimilarity.service;

import com.khalouda.filesimilarity.model.FileContent;

import java.util.List;

public interface FileReaderService {
    FileContent readFile(String filePath);
    List<String> getTextFilesInDirectory(String directoryPath);
}
