package com.example.demo.service;

import com.example.demo.model.FileBlob;
import com.example.demo.repository.FileBlobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class FileBlobService {

    @Autowired
    private FileBlobRepository fileBlobRepository;

    public FileBlob saveFile(MultipartFile file) throws IOException {
        String storedName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        FileBlob blob = new FileBlob();
        blob.setOriginalFilename(file.getOriginalFilename());
        blob.setStoredFilename(storedName);
        blob.setContentType(file.getContentType());
        blob.setSize(file.getSize());
        blob.setUploadedAt(LocalDateTime.now());
        blob.setData(file.getBytes());

        return fileBlobRepository.save(blob);
    }

    public List<FileBlob> listFiles() {
        return fileBlobRepository.findAll();
    }

    public Optional<FileBlob> getFile(String storedFilename) {
        return fileBlobRepository.findByStoredFilename(storedFilename);
    }
}
