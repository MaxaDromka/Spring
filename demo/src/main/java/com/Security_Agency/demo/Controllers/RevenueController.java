package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Contracts;
import com.Security_Agency.demo.Revenue;
import com.Security_Agency.demo.Service.ContractsService;
import com.Security_Agency.demo.Service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        existingRevenue.setReceiptDate(revenue.getReceiptDate());
        existingRevenue.setRevenueAmount(revenue.getRevenueAmount());
        existingRevenue.setContract(revenue.getContract());

        revenueService.saveRevenue(existingRevenue);
        return "redirect:/api/revenue";
    }
    @PostMapping("/delete/{id}")
    public String deleteRevenue(@PathVariable Long id) {
        revenueService.deleteRevenue(id);
        return "redirect:/api/revenue";
    }



}
