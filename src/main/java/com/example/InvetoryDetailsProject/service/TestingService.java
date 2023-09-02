package com.example.InvetoryDetailsProject.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestingService {

    public void getReport() throws JRException {
        try {

            JasperReport jasperReport = JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/jarper/src/main/resources/test.jrxml");

            // Create a list of data (example with two rows)
            List<Map<String, Object>> data = new ArrayList<>();

            Map<String, Object> row1 = new HashMap<>();
            row1.put("field1", "Data 1");
            row1.put("field2", "Data 2");

            Map<String, Object> row2 = new HashMap<>();
            row2.put("field1", "Data 3");
            row2.put("field2", "Data 4");

            data.add(row1);
            data.add(row2);

            // Create a JRBeanCollectionDataSource with the data
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

            // Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

            // Export the report to PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/mahadeva/Desktop/test.pdf");

            System.out.println("PDF report generated successfully.");
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
}
