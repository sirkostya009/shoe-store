package ua.sirkostya009.picturemicroservice.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileServiceImpl implements FileService {
    @Value("${path-to-files}")
    private String path;

    private static byte[] defaultBytes;

    @PostConstruct
    public void init() throws IOException {
        defaultBytes = Files.readAllBytes(path("misaki.jpg"));
    }

    @Override
    public byte[] bytesFor(String fileName, String fileExtension) {
        try {
            return Files.readAllBytes(path(fileName + fileExtension));
        } catch (IOException e) {
            return defaultBytes;
        }
    }

    private Path path(String fileName) {
        return Path.of(path + "/" + fileName);
    }
}
