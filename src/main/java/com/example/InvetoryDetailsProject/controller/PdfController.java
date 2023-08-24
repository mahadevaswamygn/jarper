package com.example.InvetoryDetailsProject.controller;

import com.example.InvetoryDetailsProject.service.*;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


@Controller
public class PdfController {

    @Autowired
    ReportService reportService;

    @Autowired
    OriyaService oriyaService;

    @Autowired
    KannadaService kannadaService;

    @Autowired
    TheluguService theluguService;

    @Autowired
    EnglishService englishService;

    @Autowired
    TamilService tamilService;

    @Autowired
    NoticeOfIntimationService noticeOfIntimationService;

    @Autowired
    LeneMarketingService leneMarketingService;

    @Autowired
    MemorandumOfEntryService memorandumOfEntryService;

    @GetMapping("/generate-pdf")
    public String generatePdf() throws JRException, IOException {
        reportService.generateHindi();

        return "success";

    }

    @GetMapping(value = "/get-oriya-pdf")
    public String getOriyaPdf() throws JRException, IOException {
        oriyaService.getOriyaPdf();
        return "success";
    }
    @GetMapping(value = "/get-telugu-pdf")
    public String getTeluguPdf() throws JRException, IOException {
        theluguService.getTheluguPdf();
         return "success";
    }
    @GetMapping(value = "/get-kannada-pdf")
    public String getKannadaPdf() throws JRException, IOException {
        kannadaService.getKannadaPdf();
        return "success";
    }
    @GetMapping(value = "/get-english-pdf")
    public String getEnglishPdf() throws JRException, IOException {
        englishService.getEnglishPdf();
        return "success";
    }

    @GetMapping(value = "/get-tamil-pdf")
    public String getTamilPdf() throws JRException, IOException {
        tamilService.getThamilPdf();
        return "success";
    }

    @GetMapping(value = "/get-noticeOfIntimation-pdf")
    public String getNoticeOfIntimationPdf() throws JRException, IOException {
        noticeOfIntimationService.getnoticeOfIntimationPdf();
        return "success";
    }

    @GetMapping(value = "/get-leneMarketing-pdf")
    public String getLeneMarketingPdf() throws JRException, IOException {
        leneMarketingService.getLeneMarketingPdf();
        return "success";
    }

    @GetMapping(value = "/get-MemorandumOfEntry-pdf")
    public String getMemorandumOfEntryPdf() throws JRException, IOException {
        memorandumOfEntryService.getMemorandumOfEntryPdf();
        return "success";
    }
}
