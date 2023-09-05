package com.example.InvetoryDetailsProject.service;

import com.example.InvetoryDetailsProject.Dto.DocumentDto;
import com.example.InvetoryDetailsProject.Dto.TrancheDisbursementDetails;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class LoanScheduleService {
    public void getloanSchedulePdf() throws JRException, IOException {
        List<JasperPrint> prints = new ArrayList<>();


        HashMap<String, Object> parameters01 = new HashMap<>();
        parameters01.put("loanId","L12345666");
        parameters01.put("branchName","mysore branch");
        parameters01.put("applicantCurrentCity","mysore");
        parameters01.put("date","22nd jan 2024");
        parameters01.put("typeOfEntity","trust");
        parameters01.put("borrowerName","ganagaadar");
        parameters01.put("nameOfTheBorrowerInstitution","ganga school");
        parameters01.put("authorizedPersonName","kumaar");
        parameters01.put("authorisedPersonDesignation","principle");
        parameters01.put("addressOfBorrower","near gandi cicle nagara");
        parameters01.put("coBorrower1Type","trust");
        parameters01.put("coBorrower2Type","trust2");
        parameters01.put("coBorrower3Type","trust3");
        parameters01.put("nameOfCoBorrower1", " ganaga kumar");
        parameters01.put("nameOfCoBorrower2", " ganaga kumar");
        parameters01.put("nameOfCoBorrower3", " ganaga kumar");
        parameters01.put("addressOfCoBorrower1", "mysore");
        parameters01.put("addressOfCoBorrower2", "mysore");
        parameters01.put("addressOfCoBorrower3", "mysore");
        JasperReport jasperReport01= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/loasschedule/loanSchedule00.jrxml");
        JasperPrint jasperPrint01= JasperFillManager.fillReport(jasperReport01,parameters01,new JREmptyDataSource());
        prints.add(jasperPrint01);


        HashMap<String, Object> parameters02 = new HashMap<>();
        parameters02.put("loanId","L1234555");
        parameters02.put("date","22nd jan 2025");
        parameters02.put("finalLoanAmount","3500000");
        parameters02.put("finalLoanAmountInWords","thirty five lacks");
        parameters02.put("purposeOfLoan","education");
        parameters02.put("loanType","fixed");
        parameters02.put("loanTenor" ," new tennor");
        parameters02.put("rateOfInterestPerAnnum","14");
        parameters02.put("interestType","fixed");
        parameters02.put("emiAmount","350005");
        parameters02.put("emiDueDate","23 may 3030");
        parameters02.put("dateOfFirstInstallment","23 apr 2030");
        parameters02.put("dateOfLastInstallment","22 jan 3030");
        parameters02.put("sumOfAdvanceEmi" ,"300000");
        parameters02.put("sumOfLegalAndAmpTechnicalIGST","0001");
        parameters02.put("sumOfLegalAndAmpTechnicalSGST","0002");
        parameters02.put("sumOfLegalAndTechnicalCharge","0003");
        parameters02.put("sumOfLegalAndAmpTechnicalCGST","0004");

        JasperReport jasperReport02= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/loasschedule/loanSchedule01.jrxml");
        JasperPrint jasperPrint02= JasperFillManager.fillReport(jasperReport02,parameters02,new JREmptyDataSource());
        prints.add(jasperPrint02);


        HashMap<String, Object> parameters03 = new HashMap<>();

        List<TrancheDisbursementDetails> data=new ArrayList<>();
        for (int i=1;i<4;i++)
        {
           TrancheDisbursementDetails documentDto=new TrancheDisbursementDetails("1"+i,"1234","22nd jan 2023");
            data.add(documentDto);
        }
        JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(data);
        parameters03.put("collectionBeanParameter",dataSource);
        parameters03.put("wonerOfProperty1","jagan");
//        parameters03.put("wonerOfProperty2","mohan");
        parameters03.put("addressOfProperty1" , " near gana nagar bellandur cross");
//        parameters03.put("addressOfProperty2" , " near gana nagar bellandur cross");

        JasperReport jasperReport03= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/loasschedule/loanSchedule02.jrxml");
        JasperPrint jasperPrint03= JasperFillManager.fillReport(jasperReport03,parameters03,new JREmptyDataSource());
        prints.add(jasperPrint03);

        HashMap<String, Object> parameters04 = new HashMap<>();
        JasperReport jasperReport04= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/loasschedule/loanSchedule03.jrxml");
        JasperPrint jasperPrint04= JasperFillManager.fillReport(jasperReport04,parameters04,new JREmptyDataSource());
        prints.add(jasperPrint04);




        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(SimpleExporterInput.getInstance(prints));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));

        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCreatingBatchModeBookmarks(true);
        configuration.setCompressed(true);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/loanSchedule.pdf");
        out.write(bytes);
        out.close();
    }
}
