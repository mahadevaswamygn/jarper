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
public class MotdService {
    public void getMOTDPdf() throws IOException, JRException {
        List<JasperPrint> prints = new ArrayList<>();

        HashMap<String, Object> parameters01 = new HashMap<>();
        parameters01.put("date", "1st jun 2023");
        parameters01.put("propertyCity","bengaluru");
        parameters01.put("wonerOfProperty","mahadeva");
        parameters01.put("addressOfProperty","near gaandi nagar mysore");
        parameters01.put("branchaddress","near hennur cross , hora valaya ring road, bengaluru");
        parameters01.put("purposeOfLoan","for higher education");
        parameters01.put("borrowerName","naganna");
        parameters01.put("approvedLoanAmountIncludingInsurance","2500000");
        JasperReport jasperReport01= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/motd/motd00.jrxml");
        JasperPrint jasperPrint01= JasperFillManager.fillReport(jasperReport01,parameters01,new JREmptyDataSource());
        prints.add(jasperPrint01);




        HashMap<String, Object> parameters02 = new HashMap<>();
        parameters02.put("addressOfProperty","nrer gaandi nagar mysore");
        parameters02.put("intentOfProperty","30 *n 40");
        parameters02.put("north","30 * 40");
        parameters02.put("south","90 * 40");
        parameters02.put("east","60 * 40");
        parameters02.put("west","45 * 50");
        parameters02.put("wonerOfProperty", " nagarajanna");
        JasperReport jasperReport02= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/motd/motd01.jrxml");
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
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/motd.pdf");
        out.write(bytes);
        out.close();
    }
}
