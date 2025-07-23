package com.khalouda.filesimilarity.service.impl;

import com.khalouda.filesimilarity.config.ApplicationConfig;
import com.khalouda.filesimilarity.exception.FileProcessingException;
import com.khalouda.filesimilarity.model.FileContent;
import com.khalouda.filesimilarity.service.FileReaderService;
import com.khalouda.filesimilarity.util.WordExtractor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileReaderServiceImpl implements FileReaderService {
    private final WordExtractor wordExtractor;
    private final ApplicationConfig appConfig;

    @Cacheable(value = "fileContent", key = "#filePath")
    @Override
    public FileContent readFile(String filePath) {
        log.info("reading file: {}", filePath);
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path))
                throw new FileProcessingException("file not found: " + filePath);

            long fileSize=Files.size(path);
            if (fileSize>appConfig.getMaxSizeInBytes()) {
                throw new FileProcessingException(
                        "File too large! (max: "+  appConfig.getMaxSizeMb() + " MB)"
                );
            }

            String content = Files.readString(path);
            Set<String> words = wordExtractor.extractWords(content);

            return FileContent.builder()
                    .fileName(path.getFileName().toString())
                    .filePath(filePath)
                    .words(words)
                    .numOfWords(words.size())
                    .build();

        }
        catch (IOException e) {
            throw new FileProcessingException("Error reading file: " + filePath, e);
        }
    }

    @Override
    public List<String> getTextFilesInDirectory(String directoryPath) {
        log.info("reading files of directory: {}", directoryPath);

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            List<String> files = paths
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(string -> string.toLowerCase().endsWith(".txt"))
                    .collect(Collectors.toList());

            log.info("found {} text files", files.size());
            return files;

        } catch (IOException e) {
            throw new FileProcessingException("Error scanning directory: " + directoryPath, e);
        }
    }
}
