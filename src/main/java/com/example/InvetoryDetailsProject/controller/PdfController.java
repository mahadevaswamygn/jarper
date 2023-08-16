package com.example.InvetoryDetailsProject.controller;

import com.example.InvetoryDetailsProject.Dto.PdfGenerator;
import com.example.InvetoryDetailsProject.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class PdfController {

    @Autowired
    ReportService reportService;

    @GetMapping("/generate-pdf")
    public String generatePdf() throws JRException, IOException {
        reportService.generateHindi();

        return "success";

    }
}
