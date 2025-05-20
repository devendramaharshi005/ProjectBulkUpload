package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class FileMetadataFS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFilename;
    private String storedFilename;
    private Long size;
    private LocalDateTime uploadedAt;

    // ✅ Default constructor (required by JPA)
    public FileMetadataFS() {}

    // ✅ Full-argument constructor (you’ll use this one)
    public FileMetadataFS(Long id, String originalFilename, String storedFilename,
                          Long size, LocalDateTime uploadedAt) {
        this.id = id;
        this.originalFilename = originalFilename;
        this.storedFilename = storedFilename;
        this.size = size;
        this.uploadedAt = uploadedAt;
    }

    // ✅ Getters & Setters (if Lombok is not used)
    public String getOriginalFilename() { return originalFilename; }
    public void setOriginalFilename(String originalFilename) { this.originalFilename = originalFilename; }

    public String getStoredFilename() { return storedFilename; }
    public void setStoredFilename(String storedFilename) { this.storedFilename = storedFilename; }

    public Long getSize() { return size; }
    public void setSize(Long size) { this.size = size; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
