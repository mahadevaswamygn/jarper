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

    @Autowired
    DSRADeclarationService dsraDeclarationService;

    @Autowired
    MITCImportentTermsAndConditionsService mitcImportentTermsAndConditionsService;

    @Autowired
    MotdService motdService;

    @Autowired
    DisbursementRequestService disbursementRequestService;

    @Autowired
    BoardResolutionService boardResolutionService;

    @Autowired
    SupplymentoryService supplymentoryService;

    @Autowired
    SIMPLEMORTGAGEDEEDService simplemortgagedeedService;

    @Autowired
    LoanScheduleService loanScheduleService;

    @Autowired
    TestingService testingService;

    @Autowired
    DemandPolicyService demandPolicyService;

    @Autowired
    InsuranceForm1Service insuranceForm1Service;

    @Autowired
    InsuranceForm2Service insuranceForm2Service;

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

    @GetMapping(value = "/get-DSRA-Declaration-pdf")
    public String getDSRADeclarationPdf() throws JRException, IOException {
        dsraDeclarationService.getDSRADeclarationPdf();
        return "success";
    }

    @GetMapping(value = "/get-MICTImportentTermsAndConditions-pdf")
    public String getMICTImportentTermsAndConditionsPdf() throws JRException, IOException {
        mitcImportentTermsAndConditionsService.getMICTImportentTermsAndConditionsPdf();
        return "success";
    }

    @GetMapping(value = "/get-MOTD-pdf")
    public String getMOTDPdf() throws JRException, IOException {
       motdService.getMOTDPdf();
        return "success";
    }

    @GetMapping(value = "/get-DisbursementRequest-pdf")
    public String getDisbursementRequestPdf() throws JRException, IOException {
        disbursementRequestService.getDisbursementRequestPdf();
        return "success";
    }

    @GetMapping(value = "/get-BoardResolution-pdf")
    public String getBoardResolutionPdf() throws JRException, IOException {
        boardResolutionService.getBoardResolutionPdf();
        return "success";
    }

    @GetMapping(value = "/get-Supplymentory-pdf")
    public String getSupplymentoryPdf() throws JRException, IOException {
        supplymentoryService.getSupplymentoryPdf();
        return "success";
    }
    @GetMapping(value = "/get-simplemortgagedeed-pdf")
    public String getsimplemortgagedeedPdf() throws JRException, IOException {
        simplemortgagedeedService.getSIMPLEMORTGAGEDEEDPdf();
        return "success";
    }

    @GetMapping(value = "/get-loanSchedule-pdf")
    public String getloanSchedulePdf() throws JRException, IOException {
        loanScheduleService.getloanSchedulePdf();
        return "success";
    }

    @GetMapping(value = "/get-test-pdf")
    public String getTestPdf() throws JRException, IOException {
        testingService.getReport();
        return "success";
    }

    @GetMapping(value = "/get-DemandPolicy-pdf")
    public String getDemandPolicyPdf() throws JRException, IOException {
        demandPolicyService.getDemandPolicyPdf();
        return "success";
    }

    @GetMapping(value = "/get-InsuranceForm1-pdf")
    public String getInsuranceForm1Pdf() throws JRException, IOException {
       insuranceForm1Service.getInsuranceForm1Pdf();
        return "success";
    }

    @GetMapping(value = "/get-InsuranceForm2-pdf")
    public String getInsuranceForm2Pdf() throws JRException, IOException {
        insuranceForm2Service.getInsuranceForm2Pdf();
        return "success";
    }
}
