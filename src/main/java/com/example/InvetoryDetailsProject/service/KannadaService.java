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
public class KannadaService {

    public void getKannadaPdf() throws JRException, IOException {
        List<JasperPrint> prints = new ArrayList<>();

        HashMap<String, Object> parameters01 = new HashMap<>();
        HashMap<String, Object> parameters02 = new HashMap<>();
        HashMap<String, Object> parameters = new HashMap<>();
        parameters01.put("agreementNumber","1234dews");
        parameters02.put("loanId","Li1234sdd");

        JasperReport jasperReport01= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/kannada/ka01.jrxml");
        JasperPrint jasperPrint01= JasperFillManager.fillReport(jasperReport01,parameters01,new JREmptyDataSource());
        prints.add(jasperPrint01);
        JasperReport jasperReport02=JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/kannada/ka02.jrxml");
        JasperPrint jasperPrint02=JasperFillManager.fillReport(jasperReport02,parameters02,new JREmptyDataSource());
        prints.add(jasperPrint02);
        for (int i = 3; i <= 17; i++) {
            JasperPrint print = null;
            String pageNum = String.valueOf(i);
            if (pageNum.length() == 1) {
                pageNum = "0" + pageNum;
            }
            String fileName = "ka" + pageNum + ".jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/kannada/" + fileName);

            print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            prints.add(print);
        }
        HashMap<String,Object> parameters18=new HashMap<>();
        parameters18.put("place","Mysore");
        parameters18.put("date","23/04/2023");
        parameters18.put("signOfPerson1","sidda");
        parameters18.put("nameOfPerson1","siddaraju R");
        parameters18.put("signOfPerson2","loki");
        parameters18.put("nameOfPerson2","lokesh J");
        parameters18.put("signOfPerson3","swamy");
        parameters18.put("nameOfPerson3","Mahadeva Swamy GN");
        JasperReport jasperReport18=JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/kannada/ka18.jrxml");
        JasperPrint jasperPrint18=JasperFillManager.fillReport(jasperReport18,parameters18,new JREmptyDataSource());
        prints.add(jasperPrint18);

        HashMap parameters19=new HashMap<>();
        parameters19.put("varthanaOfficer","Kumar");

        JasperReport jasperReport19=JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/kannada/ka19.jrxml");
        JasperPrint jasperPrint19=JasperFillManager.fillReport(jasperReport19,parameters19,new JREmptyDataSource());
        prints.add(jasperPrint19);


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
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/kannada.pdf");
        out.write(bytes);
        out.close();
    }
}
