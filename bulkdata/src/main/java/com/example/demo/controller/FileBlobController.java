package com.example.demo.controller;

import com.example.demo.model.FileBlob;
import com.example.demo.service.FileBlobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/files")
public class FileBlobController {

    @Autowired
    private FileBlobService fileBlobService;

    @PostMapping("/upload-db")
    public List<FileBlob> uploadToDb(@RequestParam("files") MultipartFile[] files) throws IOException {
        List<FileBlob> uploaded = new ArrayList<>();
        for (MultipartFile file : files) {
            uploaded.add(fileBlobService.saveFile(file));
        }
        return uploaded;
    }

    @GetMapping("/list-db")
    public List<FileBlob> listDbFiles() {
        return fileBlobService.listFiles();
    }

    @GetMapping("/download-db/{filename}")
    public ResponseEntity<byte[]> downloadFromDb(@PathVariable String filename) {
        Optional<FileBlob> blobOpt = fileBlobService.getFile(filename);
        if (blobOpt.isEmpty()) return ResponseEntity.notFound().build();

        FileBlob file = blobOpt.get();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getOriginalFilename() + "\"")
                .body(file.getData());
    }
}
