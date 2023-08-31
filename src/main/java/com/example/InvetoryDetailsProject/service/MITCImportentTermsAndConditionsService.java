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

@Service
public class MITCImportentTermsAndConditionsService {
    public void getMICTImportentTermsAndConditionsPdf() throws JRException, IOException {
        List<JasperPrint> prints = new ArrayList<>();

        HashMap<String, Object> parameters01 = new HashMap<>();
        JasperReport jasperReport01= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/mitcimportenttermsandconditions/mitc00.jrxml");
        JasperPrint jasperPrint01= JasperFillManager.fillReport(jasperReport01,parameters01,new JREmptyDataSource());
        prints.add(jasperPrint01);

        HashMap<String, Object> parameters02 = new HashMap<>();
        JasperReport jasperReport02= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/mitcimportenttermsandconditions/mitc01.jrxml");
        JasperPrint jasperPrint02= JasperFillManager.fillReport(jasperReport02,parameters02,new JREmptyDataSource());
        prints.add(jasperPrint02);

        HashMap<String, Object> parameters03= new HashMap<>();
        JasperReport jasperReport03= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/mitcimportenttermsandconditions/mitc02.jrxml");
        JasperPrint jasperPrint03= JasperFillManager.fillReport(jasperReport03,parameters03,new JREmptyDataSource());
        prints.add(jasperPrint03);

        HashMap<String, Object> parameters04= new HashMap<>();
        JasperReport jasperReport04= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/mitcimportenttermsandconditions/mitc03.jrxml");
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
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/mitc.pdf");
        out.write(bytes);
        out.close();
    }
}
