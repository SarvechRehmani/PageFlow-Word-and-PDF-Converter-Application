package com.pageflow.services;


import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfConversionService {

    public byte[] convertPdfToWord(MultipartFile file) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Load the PDF document
        Document pdfDocument = new Document(file.getInputStream());
        // Convert PDF to Word format (DOCX)
        pdfDocument.save(outputStream, SaveFormat.DocX);
        return outputStream.toByteArray();
    }
    // ADD MORE METHOD FOR PDF TO ANOTHER EXTENSION CONVERSION

    public byte[] convertPdfToExcel(MultipartFile file) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Load the PDF document
        Document pdfDocument = new Document(file.getInputStream());
        // Convert PDF to Excel format (Excel)
        pdfDocument.save(outputStream, SaveFormat.Excel);
        return outputStream.toByteArray();
    }

    public byte[] convertPdfToPPT(MultipartFile file) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Load the PDF document
        Document pdfDocument = new Document(file.getInputStream());
        // Convert PDF to PowerPoint format (PPTX)
        pdfDocument.save(outputStream, SaveFormat.Pptx);
        return outputStream.toByteArray();
    }
}
