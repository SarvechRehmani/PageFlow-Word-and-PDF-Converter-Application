package com.pageflow.controllers.rest;

import com.pageflow.services.PdfConversionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/converter/pdf")
public class PdfController {

    private final PdfConversionService pdfConverterService;

    public PdfController(PdfConversionService pdfConverterService) {
        this.pdfConverterService = pdfConverterService;

    }

    @PostMapping("/word")
    public ResponseEntity<byte[]> convertPdfToWord(@RequestParam("file") MultipartFile file) throws Exception {
        byte[] wordFile = pdfConverterService.convertPdfToWord(file);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=converted.docx");
        return new ResponseEntity<>(wordFile, headers, HttpStatus.OK);
    }

    @PostMapping("/excel")
    public ResponseEntity<byte[]> convertPdfToExcel(@RequestParam("file") MultipartFile file) throws Exception {
        byte[] wordFile = pdfConverterService.convertPdfToExcel(file);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=converted.xlsx");
        return new ResponseEntity<>(wordFile, headers, HttpStatus.OK);
    }

    @PostMapping("/powerpoint")
    public ResponseEntity<byte[]> convertPdfToPowerPoint(@RequestParam("file") MultipartFile file) throws Exception {
        byte[] wordFile = pdfConverterService.convertPdfToPPT(file);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=converted.pptx");
        return new ResponseEntity<>(wordFile, headers, HttpStatus.OK);
    }


}
