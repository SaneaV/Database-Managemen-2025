package com.utm.retail_be.controller;

import com.utm.retail_be.service.CsvImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/import")
@RequiredArgsConstructor
public class CsvImportController {

  private final CsvImportService csvImportService;

  @PostMapping("/sales")
  public String uploadSales(@RequestParam("file") MultipartFile file) {
    try {
      int count = csvImportService.importSales(file.getInputStream());
      return "Sales data imported successfully: " + count;
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }

  @PostMapping("/products")
  public String uploadProducts(@RequestParam("file") MultipartFile file) {
    try {
      int count = csvImportService.importProducts(file.getInputStream());
      return "Products imported: " + count;
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }

  @PostMapping("/shops")
  public String uploadShops(@RequestParam("file") MultipartFile file) {
    try {
      int count = csvImportService.importShops(file.getInputStream());
      return "Shops imported: " + count;
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }

  @PostMapping("/discounts")
  public String uploadDiscounts(@RequestParam("file") MultipartFile file) {
    try {
      int count = csvImportService.importDiscounts(file.getInputStream());
      return "Discounts imported: " + count;
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }


  @PostMapping("/dates")
  public String uploadDates(@RequestParam("file") MultipartFile file) {
    try {
      int count = csvImportService.importDateDetails(file.getInputStream());
      return "DateDetails imported: " + count;
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }

}

