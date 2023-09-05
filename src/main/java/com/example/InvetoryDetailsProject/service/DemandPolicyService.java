package com.example.InvetoryDetailsProject.service;

import com.example.InvetoryDetailsProject.Dto.BorrowerDetails;
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
import java.util.Map;

@Service
public class DemandPolicyService {
    public void getDemandPolicyPdf() throws JRException, IOException {
        List<JasperPrint> prints = new ArrayList<>();

        Map<String,Object> parameters01=new HashMap<>();
        List<BorrowerDetails> data=new ArrayList<>();

        BorrowerDetails b1 = new BorrowerDetails("Borrower","naaganna");
        BorrowerDetails b2 = new BorrowerDetails("Co-borrower1","shankar");
        BorrowerDetails b3 = new BorrowerDetails("Co-borrower2","kumaaranna");
        data.add(b1);
        data.add(b2);
        data.add(b3);
        JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(data);
        parameters01.put("collectionDataParameter",dataSource);
        parameters01.put("date","22nd jan 3030");
        parameters01.put("borrowerCurrentCity","Mysore");
        JasperReport jasperReport01= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/demandpolicy/DemandPolicyNote.jrxml");
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
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/demandPolicy.pdf");
        out.write(bytes);
        out.close();
    }
}
