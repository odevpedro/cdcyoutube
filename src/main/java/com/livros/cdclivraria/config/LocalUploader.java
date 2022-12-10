package com.livros.cdclivraria.config;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class LocalUploader implements Uploader {
    @Override
    public String upload(MultipartFile file) {
        System.out.println("enviando arquivo");
        return "something"+file.getOriginalFilename();
    }
}
