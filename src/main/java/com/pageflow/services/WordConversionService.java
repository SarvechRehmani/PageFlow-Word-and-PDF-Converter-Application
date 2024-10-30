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
    // ADD MORE METHOD FOR WORD TO ANOTHER EXTENSION CONVERSION

    public byte[] convertWordToHTML(MultipartFile file) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // Load the Word document from the input stream
            Document document = new Document(file.getInputStream());

            // Save the document as HTML to the output stream
            document.save(outputStream, SaveFormat.HTML);

            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new IOException("Error converting Word to HTML", e);
        }
    }

    public byte[] convertWordToJPEG(MultipartFile file) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // Load the Word document from the input stream
            Document document = new Document(file.getInputStream());

            // Save the document as JPEG to the output stream
            document.save(outputStream, SaveFormat.JPEG);

            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new IOException("Error converting Word to JPEG", e);
        }
    }
}
