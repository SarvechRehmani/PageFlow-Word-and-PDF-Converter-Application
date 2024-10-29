package com.pageflow.services;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class WordConversionService {

    public byte[] convertWordToPdf(MultipartFile file) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // Load the Word document from the input stream
           Document document = new Document(file.getInputStream());

            // Save the document as PDF to the output stream
            document.save(outputStream, SaveFormat.PDF);

            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new IOException("Error converting Word to PDF", e);
        }
    }

}