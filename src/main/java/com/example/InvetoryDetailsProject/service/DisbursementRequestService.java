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
public class DisbursementRequestService {

    public void getDisbursementRequestPdf() throws JRException, IOException {
        List<JasperPrint> prints = new ArrayList<>();

        HashMap<String, Object> parameters01 = new HashMap<>();
        parameters01.put("loanId","L1234567");
        JasperReport jasperReport01= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/disbursementrequest/disbursementRequest00.jrxml");
        JasperPrint jasperPrint01= JasperFillManager.fillReport(jasperReport01,parameters01,new JREmptyDataSource());
        prints.add(jasperPrint01);

        HashMap<String, Object> parameters02 = new HashMap<>();
        parameters02.put("date","22nd jun 2022");
        parameters02.put("place","Mysore");
        JasperReport jasperReport02= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/disbursementrequest/disbursementRequest01.jrxml");
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
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/DisbursementRequestPdf.pdf");
        out.write(bytes);
        out.close();

    }
}
