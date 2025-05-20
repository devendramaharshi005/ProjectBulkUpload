package com.example.demo.controller;

import com.example.demo.model.FileMetadataFS;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload-fs")
    public List<FileMetadataFS> uploadFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        List<FileMetadataFS> uploaded = new ArrayList<>();
        for (MultipartFile file : files) {
            uploaded.add(fileService.saveFile(file));
        }
        return uploaded;
    }

    @GetMapping("/list-fs")
    public List<FileMetadataFS> listAllFiles() {
        return fileService.listFiles();
    }

    @GetMapping("/download-fs/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws IOException {
        Optional<FileMetadataFS> metaOpt = fileService.getMetadata(filename);
        if (metaOpt.isEmpty()) return ResponseEntity.notFound().build();

        Resource resource = fileService.loadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + metaOpt.get().getOriginalFilename() + "\"")
                .body(resource);
    }
}
