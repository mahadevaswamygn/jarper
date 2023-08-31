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
import java.util.Map;

@Service
public class EnglishService {

    public void getEnglishPdf() throws JRException, IOException {
        Map<String, Object> parameters01 = new HashMap<>();
        Map<String, Object> parameters02 = new HashMap<>();
        parameters01.put("agreementNumber", "1234dews");
        parameters02.put("loanId", "Li1234sdd");

        List<JasperPrint> prints = new ArrayList<>();
        String filePath="https://s3.ap-south-1.amazonaws.com/com.varthana.studentloan-staging/SchoolLoans/english/english01.jrxml";
        JasperReport jasperReport01 = JasperCompileManager.compileReport(filePath);
        JasperPrint jasperPrint01 = JasperFillManager.fillReport(jasperReport01, parameters01, new JREmptyDataSource());
        prints.add(jasperPrint01);
        JasperReport jasperReport02 = JasperCompileManager.compileReport("https://s3.ap-south-1.amazonaws.com/com.varthana.studentloan-staging/SchoolLoans/english/english02.jrxml");
        JasperPrint jasperPrint02 = JasperFillManager.fillReport(jasperReport02, parameters02, new JREmptyDataSource());
        prints.add(jasperPrint02);

        HashMap<String, Object> parameters = new HashMap<>();
        for (int i = 3; i <= 13; i++) {
            JasperPrint print = null;
            String pageNum = String.valueOf(i);
            if (pageNum.length() == 1) {
                pageNum = "0" + pageNum;
            }
            String fileName = "english" + pageNum + ".jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport("https://s3.ap-south-1.amazonaws.com/com.varthana.studentloan-staging/SchoolLoans/english/" + fileName);

            print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            prints.add(print);
        }

        Map<String, Object> parameters14 = new HashMap<>();
        parameters14.put("place", "Mysore");
        parameters14.put("date", "23/04/2023");
        parameters14.put("signOfPerson1", "sidda");
        parameters14.put("nameOfPerson1", "siddaraju R");
        parameters14.put("signOfPerson2", "loki");
        parameters14.put("nameOfPerson2", "lokesh J");
        parameters14.put("signOfPerson3", "swamy");
        parameters14.put("nameOfPerson3", "Mahadeva Swamy GN");
        parameters14.put("varthanaOfficer","manjunatha");

        JasperReport jasperReport14 = JasperCompileManager.compileReport("https://s3.ap-south-1.amazonaws.com/com.varthana.studentloan-staging/SchoolLoans/english/english14.jrxml");
        JasperPrint jasperPrint14 = JasperFillManager.fillReport(jasperReport14, parameters14, new JREmptyDataSource());
        prints.add(jasperPrint14);


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(SimpleExporterInput.getInstance(prints));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));

        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCreatingBatchModeBookmarks(true);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/englishs3.pdf");
        out.write(bytes);
        out.close();
    }
}
