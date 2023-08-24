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
public class MemorandumOfEntryService {

    public void getMemorandumOfEntryPdf() throws JRException, IOException {
        List<JasperPrint> prints = new ArrayList<>();

        HashMap<String, Object> parameters01 = new HashMap<>();
        parameters01.put("date","24-04-2024");
        parameters01.put("wonerOfProperty",",Mahadevanna");
        JasperReport jasperReport01= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/memorandumofentry/memorandumOfEntry00.jrxml");
        JasperPrint jasperPrint01= JasperFillManager.fillReport(jasperReport01,parameters01,new JREmptyDataSource());
        prints.add(jasperPrint01);

        HashMap<String, Object> parameters02 = new HashMap<>();
        parameters02.put("date","24-04-2024");
        parameters02.put("wonerOfProperty",",Mahadevanna");
        parameters02.put("branchOfficeAddress",",bengaluru horavalaya , ring road");
        parameters02.put("borrowerName","siddaraju");
        parameters02.put("borrowerAddress","2nd cross, kurad bidi, ganjam, srirangapattana");
        parameters02.put("finalLoanAmountIncludingInsurance","240000000");
        parameters02.put("finalLoanAmountIncludingInsuranceInWords","twenty lacks twent thousand twenty");
        JasperReport jasperReport02= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/memorandumofentry/memorandumOfEntry01.jrxml");
        JasperPrint jasperPrint02= JasperFillManager.fillReport(jasperReport02,parameters02,new JREmptyDataSource());
        prints.add(jasperPrint02);

        HashMap<String, Object> parameters03 = new HashMap<>();
        parameters03.put("addressOfProperty1","near ganag nagar mysore");
        parameters03.put("addressOfProperty2","near ganag nagar mysore");
        parameters03.put("addressOfProperty3","near ganag nagar mysore");
        parameters03.put("intentOfProperty1","20 * 30");
        parameters03.put("intentOfProperty2","100 * 30");
        parameters03.put("intentOfProperty3","200 * 50");
        parameters03.put("property1EastBy","300");
        parameters03.put("property1WestBy","400");
        parameters03.put("property1NorthBy","120");
        parameters03.put("property1SouthBy","140");
        parameters03.put("property2EastBy","300");
        parameters03.put("property2WestBy","300");
        parameters03.put("property2NorthBy","300");
        parameters03.put("property2SouthBy","300");
        parameters03.put("property3EastBy","400");
        parameters03.put("property3WestBy","400");
        parameters03.put("property3NorthBy","400");
        parameters03.put("property3SouthBy","400");
        JasperReport jasperReport03= JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/memorandumofentry/memorandumOfEntry02.jrxml");
        JasperPrint jasperPrint03= JasperFillManager.fillReport(jasperReport03,parameters03,new JREmptyDataSource());
        prints.add(jasperPrint03);




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
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/memorandumOfEntry.pdf");
        out.write(bytes);
        out.close();
    }
}
