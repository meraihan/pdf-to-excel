package com.rupali.bank.pdftoexcel.service;

import com.rupali.bank.pdftoexcel.model.ConvertFile;
import com.rupali.bank.pdftoexcel.model.SampleData;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
                log.info("text: {}", pdfFileInText);
                writeData(pdfFileInText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeData(String pdfData) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Blank Sheet");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        SampleData sampleData = new SampleData();

        data.put("1", new Object[] {"DATE", "RECONCILATION DATE", "TRANSACTION", "ACCOUNT", "ISSUER", "DEBIT", "CREDIT", "BALANCE"});
        data.put("2", new Object[] {""});
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("GL-Ledger.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("General ledger is written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
