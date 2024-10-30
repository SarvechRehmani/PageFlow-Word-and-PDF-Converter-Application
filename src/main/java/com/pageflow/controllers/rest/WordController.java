package com.pageflow.controllers.rest;

import com.pageflow.services.WordConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/converter/word")
public class WordController {

    private final WordConversionService wordConversionService;

    public WordController(WordConversionService wordConversionService) {
        this.wordConversionService = wordConversionService;
    }


    @PostMapping("/pdf")
    public ResponseEntity<byte[]> convertWordToPdf(@RequestParam("file") MultipartFile file) {
        System.out.println(1);
        if (file.isEmpty() || !file.getContentType().equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
            return ResponseEntity.badRequest().body("Invalid file type or empty file".getBytes());
        }
        System.out.println(1);
        try {
            byte[] pdfBytes = wordConversionService.convertWordToPdf(file);
            System.out.println(7);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"converted.pdf\"")
                    .body(pdfBytes);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(("Error converting file: " + e.getMessage()).getBytes());
        }
    }

    @PostMapping("/pdf-extra")
    public ResponseEntity<byte[]> convertWordToPdfExtra(@RequestParam("file") MultipartFile file) {
        System.out.println("Word to PDF Extra");
        try {
            System.out.println(1);
            byte[] pdfBytes = wordConversionService.convertWordToPdf(file);
            System.out.println(7);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"converted.pdf\"")
                    .body(pdfBytes);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(("Error converting file: " + e.getMessage()).getBytes());
        }

    }

}
