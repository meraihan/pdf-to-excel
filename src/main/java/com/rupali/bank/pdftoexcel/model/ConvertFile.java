package com.rupali.bank.pdftoexcel.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ConvertFile {
    private MultipartFile file;
}
