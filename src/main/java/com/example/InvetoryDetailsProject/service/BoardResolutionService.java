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
public class BoardResolutionService {

    public void getBoardResolutionPdf() throws JRException, IOException {
        List<JasperPrint> prints = new ArrayList<>();

        HashMap<String, Object> parameters01 = new HashMap<>();
        parameters01.put("date","22 nd july 2024");
        parameters01.put("trustName", "sri siddaganaga mata");
        parameters01.put("address","near ganga water tank");
        parameters01.put("finalLoanAmount","2400000");
        parameters01.put("approveDate","11-07-2025");
        parameters01.put("coBorrower1details","naganna , vice principle of the sadvidya education trust");
        parameters01.put("coBorrower2details","santhuraj of the sadvidya education trust");
        parameters01.put("coBorrower1Name","sagar reddy");
        parameters01.put("coBorrower1Name","nithi readdy");
        parameters01.put("coBorrowerInsuredPersion","jaganna");
        JasperReport jasperReport01= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/boardresolution/boardResolution00.jrxml");
        JasperPrint jasperPrint01= JasperFillManager.fillReport(jasperReport01,parameters01,new JREmptyDataSource());
        prints.add(jasperPrint01);


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
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/boardResolution.pdf");
        out.write(bytes);
        out.close();
    }
}
