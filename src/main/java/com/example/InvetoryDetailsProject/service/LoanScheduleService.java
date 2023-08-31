package com.example.InvetoryDetailsProject.service;

import net.sf.jasperreports.engine.*;
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
        parameters01.put("authorisedDesignation","principle");
        parameters01.put("addressOfBorrower","near gandi cicle nagara");
        parameters01.put("coBorrower1Type","trust");
        parameters01.put("coBorrower2Type","trust");
        parameters01.put("coBorrower3Type","trust");
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
        JasperReport jasperReport02= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/loasschedule/loanSchedule01.jrxml");
        JasperPrint jasperPrint02= JasperFillManager.fillReport(jasperReport02,parameters02,new JREmptyDataSource());
        prints.add(jasperPrint02);








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
