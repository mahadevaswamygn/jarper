package com.example.InvetoryDetailsProject.Dto;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class PdfGenerator {

    public void generatePdf(String xmlFilePath, String outputFilePath) {
        try {
            // Construct the URL or path to the XML file
            String fileUrl = "file://" + xmlFilePath;
            URL url = new URL(fileUrl);

            // Load the XML file
            JRReport report = JRXmlLoader.load(url.openStream());

            // Compile the report
            JasperReport jasperReport = JasperCompileManager.compileReport((InputStream) report);

            // Set up parameters and data source (if applicable)
            HashMap<String,Object> parameters=new HashMap<>();

            // Generate PDF
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            // Export PDF to output file
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputFilePath);

            System.out.println("PDF generated successfully");
        } catch (MalformedURLException e) {
            // Handle malformed URL exception
            e.printStackTrace();
        } catch (JRException e) {
            // Handle JasperReports exception
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }
}
