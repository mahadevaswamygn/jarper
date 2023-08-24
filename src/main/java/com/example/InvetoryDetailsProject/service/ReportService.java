package com.example.InvetoryDetailsProject.service;

import com.example.InvetoryDetailsProject.Dto.AmountDto;
import com.example.InvetoryDetailsProject.Dto.ProductInventoryDto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import net.sf.jasperreports.engine.fonts.FontExtensionsRegistry;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.extensions.ExtensionsRegistry;
import net.sf.jasperreports.extensions.ExtensionsRegistryFactory;

import java.awt.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;






import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    InventoryService inventoryService;

    public void genarate() throws FileNotFoundException, JRException {
        ProductInventoryDto productInventoryDto = inventoryService.inventoryOfTheProduct(2);
        File file = ResourceUtils.getFile("classpath:latesetInvenroty.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        List<ProductInventoryDto> productInventoryDtoList = new ArrayList<>();
        productInventoryDtoList.add(productInventoryDto);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productInventoryDtoList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Mahadeva Sawamy");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "/home/mahadeva/Downloads/InvetoryDetailsProject/reports" + "/productsHtmlFile.html");
        JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/mahadeva/Downloads/InvetoryDetailsProject/reports" + "/productsPdfFile.pdf");
    }

    public void generateHindi() throws IOException, JRException {
        System.out.println("*************s");
        File file = ResourceUtils.getFile("classpath:englishtext.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("ParameterName","PÀ£ÀßqÀ eÁ¸Ààgï ¦rJ¥sï GzÁºÀgÀuÉ");
//        parameters.put("name","ಕನ್ನಡ");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
//        JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/mahadeva/Desktop/kannadaJasper1002.pdf");
List<JasperPrint> prints=new ArrayList<>();
prints.add(jasperPrint);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(SimpleExporterInput.getInstance(prints));

//        exporter.s
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));

        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCreatingBatchModeBookmarks(true);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/enlishtest.pdf");
        out.write(bytes);
        out.close();
    }

    public void getReport() throws FileNotFoundException, JRException {

        List<AmountDto> emiDetails = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            AmountDto amountDto = new AmountDto("22/08/2023", "100000", "14322", "27000", "3000000");
            emiDetails.add(amountDto);
        }
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("nameOfTheBorrowwer", "Mahadeva swamy gn");
        parameters.put("loanAccountNo", "1234sctzy");
        parameters.put("finalLoanAmount", "3500000");
        parameters.put("secondEMI", "32000");
        parameters.put("camTenure", "60");
        parameters.put("interestRate", "25 % per Annum");
        parameters.put("expectedDisbDate", "23/08/2023");
        parameters.put("emiStartDate", "23/09/2023");
        parameters.put("asPerTenure", "30/12/2035");

        File file = ResourceUtils.getFile("classpath:AmortizationSchedule.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(emiDetails);
        parameters.put("CollectionBeanParam", dataSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/mahadeva/Desktop/jasper1002.pdf");

    }

    public void getLoanAgrementEnglishReport() throws FileNotFoundException, JRException {
        HashMap<String, Object> parameters = new HashMap<String, Object>();
//        File file = ResourceUtils.getFile("classpath:loanAgreementEnglish02.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/src/main/resources/new/loanAgreementKannada03.jrxml");
        List<AmountDto> emiDetails = new ArrayList<>();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(emiDetails);
        parameters.put("CollectionBeanParam", dataSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/mahadeva/Desktop/Page5.pdf");
    }
//    public void getLoanAgreementKannadaReport() throws IOException, JRException {
//        // Load the font extension configuration
//        FontExtensionsRegistryFactory.getInstance().registerExtensions("myfont.xml");
//
//        // Load the compiled JasperReport
//        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("/home/mahadeva/Downloads/InvetoryDetailsProject/src/main/resources/new/loanAgreementKannada03.jasper");
//
//        List<AmountDto> emiDetails = new ArrayList<>();
//        // Populate emiDetails list if needed
//
//        Map<String, Object> parameters = new HashMap<>();
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(emiDetails);
//        parameters.put("CollectionBeanParam", dataSource);
//
//        // Fill the report and generate PDF
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
//        JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/mahadeva/Desktop/Page5.pdf");
//    }

//    public void genkannada(){
//        try {
//            // Load the Kannada font from the resources/fonts folder
//            InputStream fontStream = ReportService.class.getResourceAsStream("/fonts/NotoSansKannada-Regular.ttf");
//            Font kannadaFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
//
//            // Create font map
//            Map<String, Font> fontMap = new HashMap<>();
//            fontMap.put("KannadaFont", kannadaFont);
//
//            // Load the JasperReport JRXML template
//            InputStream reportStream = ReportService.class.getResourceAsStream("/path-to-your-jrxml-file/report.jrxml");
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
//
//            // Create a data source (replace with your data source)
////            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(yourDataList);
//
//            // Create parameters map if needed
//            Map<String, Object> parameters = new HashMap<>();
//
//            // Fill the report and apply font
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
//
//            // Apply font to the entire report
//            JRStyle defaultStyle = jasperReport.getDefaultStyle();
//            defaultStyle.setFontName("KannadaFont");
//
//            for (JRStyle style : jasperReport.getStyles()) {
//                style.setFontName("KannadaFont");
//            }
//
//            for (JasperPrint page : jasperPrint.getPages()) {
//                for (JRPrintText text : page.getMainTable().getBands()[0].getPrintTexts()) {
//                    text.setFontName("KannadaFont");
//                }
//            }
//
//            // Export the report to PDF
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "output.pdf");
//
//            System.out.println("PDF generated successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public void gen(){
        try {
            // Compile the JRXML template
            JasperReport jasperReport = JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/src/main/resources/loanAgreementHindi01.jrxml");

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), new JREmptyDataSource());

            // Export the report to PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/mahadeva/Desktop/hindisamplepdf.pdf");

            System.out.println("PDF generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void getEnglishLoanAgreement() throws JRException, IOException {
        HashMap<String, Object> parameters = new HashMap<>();
        List<JasperPrint> prints = new ArrayList<>();
        for (int i = 2; i <= 6; i++) {
            JasperPrint print = null;
            String pageNum = String.valueOf(i);
            if (pageNum.length() == 1) {
                pageNum = "0" + pageNum;
            }
            String fileName = "loanAgreementEnglish0" + pageNum + ".jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/src/main/resources/new/" + fileName);

            print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            prints.add(print);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(SimpleExporterInput.getInstance(prints));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));

        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCreatingBatchModeBookmarks(true);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/english.pdf");
        out.write(bytes);
        out.close();

    }

    public void getKannadaLoanAgreement() throws JRException, IOException {
        HashMap<String, Object> parameters = new HashMap<>();
        List<JasperPrint> prints = new ArrayList<>();
        JasperReport jasperReport0 = JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/src/main/resources/");

        JasperPrint print0 = JasperFillManager.fillReport(jasperReport0, parameters, new JREmptyDataSource());
        prints.add(print0);
        for (int i = 1; i <= 13; i++) {
            JasperPrint print = null;
            String pageNum = String.valueOf(i);
            if (pageNum.length() == 1) {
                pageNum = "0" + pageNum;
            }
            String fileName = "loanAgreementKannada" + pageNum + ".jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport("/home/mahadeva/Downloads/InvetoryDetailsProject/src/main/resources/" + fileName);

            print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            prints.add(print);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(SimpleExporterInput.getInstance(prints));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));

        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCreatingBatchModeBookmarks(true);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        OutputStream out = new FileOutputStream("/home/mahadeva/Desktop/loanAgreementEnglish.pdf");
        out.write(bytes);
        out.close();

    }
}
