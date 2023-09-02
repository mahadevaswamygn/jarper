package com.example.InvetoryDetailsProject.service;

import com.example.InvetoryDetailsProject.Dto.DocumentDto;
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
public class SupplymentoryService {

    public void getSupplymentoryPdf() throws JRException, IOException {
        List<JasperPrint> prints = new ArrayList<>();

        HashMap<String, Object> parameters01 = new HashMap<>();
        parameters01.put("date","33rd jun 3030");
        parameters01.put("propertyCity","nelamagala");
        parameters01.put("wonerOfProperty","kumaaranna");
        parameters01.put("addressOfProperty","near gaandi nagar mysor");
        parameters01.put("varthanaOfficer","kuramaranna ");
        parameters01.put("branchAddress","near hennur cross bengaluru");
        parameters01.put("approvedLoanAmountIncludingInsurance","2500000");
        parameters01.put("borrowerName","jagadeesh");
        parameters01.put("purposeOfLoan","eduv=cation");
        parameters01.put("finalLoanAmountIncludingInsurance","3500000");
        JasperReport jasperReport01= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/supplymentory/supplymentory00.jrxml");
        JasperPrint jasperPrint01= JasperFillManager.fillReport(jasperReport01,parameters01,new JREmptyDataSource());
        prints.add(jasperPrint01);


        HashMap<String, Object> parameters02 = new HashMap<>();
        parameters02.put("date" , "22nd jan 2023");
        parameters02.put("addressOfProperty","near gaandi nagar");
        parameters02.put("intentOfProperty","40 * 50 ");
        parameters02.put("wonerOfProperty","nagaaraj");
        parameters02.put("north","30");
        parameters02.put("south","xyml");
        parameters02.put("east","50");
        parameters02.put("west","30");
        List<DocumentDto> data=new ArrayList<>();
        for (int i=1;i<4;i++)
        {
            DocumentDto documentDto=new DocumentDto("pdf","1234","photoCopy");
            data.add(documentDto);
        }
        JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(data);
        parameters02.put("CollectionBeanParam",dataSource);

        JasperReport jasperReport02= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/supplymentory/supplymentory01.jrxml");
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
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/supplymentory.pdf");
        out.write(bytes);
        out.close();
    }
}
