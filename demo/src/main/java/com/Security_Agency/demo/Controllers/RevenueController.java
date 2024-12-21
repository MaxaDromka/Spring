package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Contracts;
import com.Security_Agency.demo.Revenue;
import com.Security_Agency.demo.Service.ContractsService;
import com.Security_Agency.demo.Service.RevenueService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@Controller
@RequestMapping("/api/revenue")
public class RevenueController {
    @Autowired
    private RevenueService revenueService;
    @Autowired
    private ContractsService contractService;

    @GetMapping
    public String getAllRevenue(Model model) {
        List<Revenue> revenueList = revenueService.getAllRevenue();
        model.addAttribute("revenue", revenueList);
        return "revenue";
    }

    @GetMapping("/new")
    public String createRevenueForm(Model model) {
        List<Contracts> contracts = contractService.getAllContracts();
        model.addAttribute("contracts", contracts);
        return "create_revenue_form";
    }

    @PostMapping("/create")
    public String createRevenue(@ModelAttribute Revenue revenue) {
        revenueService.saveRevenue(revenue);
        return "redirect:/revenue";
    }

    @GetMapping("/edit/{id}")
    public String editRevenueForm(@PathVariable Long id, Model model) {
        Revenue revenue = revenueService.getRevenueById(id);
        List<Contracts> contracts = contractService.getAllContracts();
        model.addAttribute("revenue", revenue);
        model.addAttribute("contracts", contracts);
        return "edit_revenue_form";
    }

    @PostMapping("/update/{id}")
    public String updateRevenue(@PathVariable Long id, @ModelAttribute Revenue revenue) {
        Revenue existingRevenue = revenueService.getRevenueById(id);

        System.out.println("Updating revenue with ID: " + existingRevenue.getId());  // Логируем ID

        existingRevenue.setReceiptDate(revenue.getReceiptDate());
        if (revenue.getContract() != null) {
            existingRevenue.setContract(revenue.getContract());
        }

        revenueService.saveRevenue(existingRevenue);

        return "redirect:/api/revenue";
    }


    @PostMapping("/delete/{id}")
    public String deleteRevenue(@PathVariable Long id) {
        revenueService.deleteRevenue(id);
        return "redirect:/api/revenue";
    }

    @GetMapping("/report")
    public ResponseEntity<byte[]> generateRevenueReport() {
        // Получаем все данные о выручке
        List<Revenue> revenueList = revenueService.getAllRevenue();

        // Создаем CSV файл в памяти
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(outputStream),
                CSVFormat.DEFAULT.withHeader("Номер контракта","Сумма"))) {
            for (Revenue revenue : revenueList) {
                // Используем getRevenueAmount() для получения суммы выручки
                csvPrinter.printRecord(revenue.getContract().getContractSerialNumber(),revenue.getRevenueAmount());
            }
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Устанавливаем правильный тип контента для файла CSV
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=revenue_report.csv");

        return ResponseEntity.ok()
                .headers(headers)
                .body(outputStream.toByteArray());
    }





}
