package com.pageflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String home(){
        return "index.html";
    }

    @GetMapping("/word-to-pdf")
    public String wordToPDF(){
        return "word2pdf.html";
    }

    @GetMapping("/pdf-to-word")
    public String PDFToWord(){
        return "pdf2word.html";
    }
}
