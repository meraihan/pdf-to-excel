package com.rupali.bank.pdftoexcel.service;

import com.rupali.bank.pdftoexcel.model.ConvertFile;
import com.rupali.bank.pdftoexcel.model.SampleData;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class ConvertPdfToExcelService {

    public void convertPdfToExcel(ConvertFile convertFile){
        try (PDDocument document = PDDocument.load(convertFile.getFile().getBytes())) {

            document.getClass();
            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + st);
                log.info("text: {}", pdfFileInText);
                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(List<SampleData> excelDataList) throws Exception {

    }

}
