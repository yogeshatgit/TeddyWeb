package com.teddyweb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/teddy-web")
@CrossOrigin(origins = "http://localhost:4200")
public class MyController {

    @Value("${upload.folder}")
    private String path;

    @GetMapping("")
    public String homePage(){
        return "Home page";
    }
    @PostMapping("/{category}")
    public void uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("category") String category){
        System.out.println("category= "+category);
        System.out.println();
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo( new File(path+ fileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
