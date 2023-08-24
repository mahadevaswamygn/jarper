package com.example.InvetoryDetailsProject.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TamilService {
    public void getThamilPdf() throws JRException, IOException {
        Map<String, Object> parameters01 = new HashMap<>();
        Map<String, Object> parameters02 = new HashMap<>();
        parameters01.put("agreementNumber", "1234dews");
        parameters02.put("loanId", "Li1234sdd");

        List<JasperPrint> prints = new ArrayList<>();
        JasperReport jasperReport01 = JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/tamil/tamil00.jrxml");
        JasperPrint jasperPrint01 = JasperFillManager.fillReport(jasperReport01, parameters01, new JREmptyDataSource());
        prints.add(jasperPrint01);
        JasperReport jasperReport02 = JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/tamil/tamil01.jrxml");
        JasperPrint jasperPrint02 = JasperFillManager.fillReport(jasperReport02, parameters02, new JREmptyDataSource());
        prints.add(jasperPrint02);

        Map<String, Object> parameters = new HashMap<>();
        for (int i = 2; i <= 16; i++) {
            JasperPrint print = null;
            String pageNum = String.valueOf(i);
            if (pageNum.length() == 1) {
                pageNum = "0" + pageNum;
            }
            String fileName = "tamil" + pageNum + ".jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/tamil/" + fileName);

            print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            prints.add(print);
        }

        Map<String, Object> parameters17 = new HashMap<>();
        parameters17.put("place", "Mysore");
        parameters17.put("date", "23/04/2023");
        parameters17.put("signOfPerson1", "sidda");
        parameters17.put("nameOfPerson1", "siddaraju R");
        parameters17.put("signOfPerson2", "loki");
        parameters17.put("nameOfPerson2", "lokesh J");
        parameters17.put("signOfPerson3", "swamy");
        parameters17.put("nameOfPerson3", "Mahadeva Swamy GN");
        parameters17.put("varthanaOfficer","manjunatha");
        JasperReport jasperReport17 = JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/tamil/tamil17.jrxml");
        JasperPrint jasperPrint17 = JasperFillManager.fillReport(jasperReport17, parameters17, new JREmptyDataSource());
        prints.add(jasperPrint17);


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
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/thamil.pdf");
        out.write(bytes);
        out.close();
    }
}
