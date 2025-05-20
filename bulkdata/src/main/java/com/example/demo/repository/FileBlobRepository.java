package com.example.demo.repository;

import com.example.demo.model.FileBlob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileBlobRepository extends JpaRepository<FileBlob, Long> {
    Optional<FileBlob> findByStoredFilename(String storedFilename);
}
