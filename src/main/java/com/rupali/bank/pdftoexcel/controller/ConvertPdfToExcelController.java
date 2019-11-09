package com.rupali.bank.pdftoexcel.controller;

import com.rupali.bank.pdftoexcel.model.ConvertFile;
import com.rupali.bank.pdftoexcel.service.ConvertPdfToExcelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ConvertPdfToExcelController {
    private final ConvertPdfToExcelService pdfToExcelService;

    public ConvertPdfToExcelController(ConvertPdfToExcelService pdfToExcelService) {
        this.pdfToExcelService = pdfToExcelService;
    }

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    @PostMapping("/convert")
    public String convertFile(@ModelAttribute("convertfile") ConvertFile convertFile) {
        pdfToExcelService.convertPdfToExcel(convertFile);
        return "redirect:/";
    }
}
