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
        if (file.isEmpty() || !file.getContentType().equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
            return ResponseEntity.badRequest().body("Invalid file type or empty file".getBytes());
        }
        try {
            byte[] pdfBytes = wordConversionService.convertWordToPdf(file);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"converted.pdf\"")
                    .body(pdfBytes);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(("Error converting file: " + e.getMessage()).getBytes());
        }
    }

    @PostMapping("/text")
    public ResponseEntity<byte[]> convertWordToText(@RequestParam("file") MultipartFile file) {
        try {
            byte[] pdfBytes = wordConversionService.convertWordToText(file);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"converted.html\"")
                    .body(pdfBytes);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(("Error converting file: " + e.getMessage()).getBytes());
        }
    }

    @PostMapping("/jpeg")
    public ResponseEntity<byte[]> convertWordToJPEG(@RequestParam("file") MultipartFile file) {
        System.out.println("Word to PDF Extra");
        try {
            System.out.println(1);
            byte[] pdfBytes = wordConversionService.convertWordToJPEG(file);
            System.out.println(7);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"converted.jpeg\"")
                    .body(pdfBytes);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(("Error converting file: " + e.getMessage()).getBytes());
        }
    }

}
