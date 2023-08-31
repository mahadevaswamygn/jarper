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
public class SIMPLEMORTGAGEDEEDService {

    public void getSIMPLEMORTGAGEDEEDPdf() throws JRException, IOException {
        List<JasperPrint> prints = new ArrayList<>();

        HashMap<String, Object> parameters01 = new HashMap<>();
        parameters01.put("propertyCity","jayanagara");
        parameters01.put("addressOfProperty","near ganaga palace");
        parameters01.put("wonerOfProperty","naganna");
        parameters01.put("date" ,"22nd jlay 20228");
        parameters01.put("branchAddress","near thilak nagar");
        parameters01.put("propertyAddress","thilak nagar road 2nd cross");//just for 2 times
        parameters01.put("borrowerName","gangaadara thilak urudu");
        parameters01.put("finalLoanAmountIncludingInsurance","24000000");
        parameters01.put("finalLoanAmountIncludingInsuranceInWords","twenty laks");
        JasperReport jasperReport01= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/SIMPLEMORTGAGEDEED/SIMPLE MORTGAGE DEED00.jrxml");
        JasperPrint jasperPrint01= JasperFillManager.fillReport(jasperReport01,parameters01,new JREmptyDataSource());
        prints.add(jasperPrint01);

        HashMap<String, Object> parameters02 = new HashMap<>();
        parameters02.put("finalLoanAmountIncludingInsurance","24000000");
        JasperReport jasperReport02= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/SIMPLEMORTGAGEDEED/SIMPLE MORTGAGE DEED01.jrxml");
        JasperPrint jasperPrint02= JasperFillManager.fillReport(jasperReport02,parameters02,new JREmptyDataSource());
        prints.add(jasperPrint02);

        HashMap<String, Object> parameters03 = new HashMap<>();
        JasperReport jasperReport03= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/SIMPLEMORTGAGEDEED/SIMPLE MORTGAGE DEED02.jrxml");
        JasperPrint jasperPrint03= JasperFillManager.fillReport(jasperReport03,parameters03,new JREmptyDataSource());
        prints.add(jasperPrint03);

        HashMap<String, Object> parameters04 = new HashMap<>();
        parameters04.put("propertyAddress","near gaandi nagar");
        parameters04.put("intentOfProperty","300 * 400");
        parameters04.put("north","300");
        parameters04.put("south","200");
        parameters04.put("east","300");
        parameters04.put("west","500");
        parameters04.put("borrowerName","kumar govind");
        parameters04.put("date","22nd julay 2024");
        JasperReport jasperReport04= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/SIMPLEMORTGAGEDEED/SIMPLE MORTGAGE DEED03.jrxml");
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
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/simpleMortAgreed.pdf");
        out.write(bytes);
        out.close();
    }
















}
