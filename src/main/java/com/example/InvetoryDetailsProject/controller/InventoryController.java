package com.example.InvetoryDetailsProject.controller;

import com.example.InvetoryDetailsProject.Dto.ProductInventoryDto;
import com.example.InvetoryDetailsProject.service.InventoryService;
import com.example.InvetoryDetailsProject.service.ReportService;
import lombok.Getter;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    ReportService reportService;

    @GetMapping(value = "/get-latest-inventory")
    public String getLatestInventory(Model model){
        List<ProductInventoryDto> allLatestInventory =inventoryService.getLatestInventory();
        model.addAttribute("InventoryOfTheProduct",allLatestInventory);
        return "inventory-details";
    }

    @GetMapping(value = "/get-latest-inventory-of-product/{productId}")
    public String getProductInventory(@PathVariable Integer productId, Model model){
        ProductInventoryDto productInventoryDto=inventoryService.inventoryOfTheProduct(productId);
        List<ProductInventoryDto> inventoryOfTheProduct=new ArrayList<>();
        inventoryOfTheProduct.add(productInventoryDto);
        model.addAttribute("InventoryOfTheProduct",inventoryOfTheProduct);
        return "inventory-details";
    }

    @GetMapping(value = "/generate-report")
    public String genarateReport() throws JRException, FileNotFoundException {
        reportService.getLoanAgrementEnglishReport();
        return "success";
    }

    @GetMapping(value = "/get-english-loan-agreement")
    public String getEnglishLoanAgreement() throws JRException, IOException {
        reportService.getEnglishLoanAgreement();
        return "success";
    }
    @GetMapping(value = "/get-kannada-loan-agreement")
    public String getKannadaLoanAgreement() throws JRException, IOException {
        reportService.getKannadaLoanAgreement();
        return "success";
    }
}
