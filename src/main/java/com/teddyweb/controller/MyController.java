package com.teddyweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/teddy-web")
@CrossOrigin(origins = "http://localhost:4200")
public class MyController {

    @GetMapping("")

    public String homePage(){
        return "Home page";
    }
    @PostMapping("/{category}")
    public void uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("category") String category){

        System.out.println("category= "+category);

        String fileName = file.getOriginalFilename();
        try {
            file.transferTo( new File("/home/yogesh/Desktop/Work/TeddyWeb1/src/assets/files/"+ fileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


   /* @PostMapping("/table/{tableName}/file-data")
    public ResponseEntity<String> loadFileData(@RequestParam("file") MultipartFile file, @PathVariable("tableName") String tableName){
        try{
            dataManagerService.loadFileData(tableName,file);
            return new ResponseEntity<>("{\"message\": \"File data load successfully.\"}", HttpStatus.OK);
        }
        catch (Exception e){
            String correlationId = UUID.randomUUID().toString();
            LOGGER.error(correlationId+" File data load failed. "+tableName,e);
            return new ResponseEntity<>(correlationId+" File data load failed. "+tableName,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
}
