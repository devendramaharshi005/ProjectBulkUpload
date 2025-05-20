package com.example.demo.service;

import com.example.demo.model.FileMetadataFS;
import com.example.demo.repository.FileMetadataFsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDateTime;

@Service
public class FileService {

    private final Path uploadDir = Paths.get("uploads");

    @Autowired
    private FileMetadataFsRepository fileRepo;

    public FileService() throws IOException {
        Files.createDirectories(uploadDir);
    }

    public FileMetadataFS saveFile(MultipartFile file) throws IOException {
        String storedName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = uploadDir.resolve(storedName);
        Files.copy(file.getInputStream(), path);

        FileMetadataFS meta = new FileMetadataFS();
        meta.setOriginalFilename(file.getOriginalFilename());
        meta.setStoredFilename(storedName);
        meta.setSize(file.getSize());
        meta.setUploadedAt(LocalDateTime.now());

        return fileRepo.save(meta);
    }

    public List<FileMetadataFS> listFiles() {
        return fileRepo.findAll();
    }

    public Resource loadFile(String storedFilename) throws IOException {
        Path filePath = uploadDir.resolve(storedFilename).normalize();
        return new UrlResource(filePath.toUri());
    }

    public Optional<FileMetadataFS> getMetadata(String storedFilename) {
        return fileRepo.findByStoredFilename(storedFilename);
    }
}
