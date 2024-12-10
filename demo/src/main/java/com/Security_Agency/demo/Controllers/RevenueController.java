package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Revenue;
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

    @GetMapping
    public String getAllRevenue(Model model) {
        List<Revenue> revenueList = revenueService.getAllRevenue();
        model.addAttribute("revenue", revenueList);
        return "revenue";
    }

    @PostMapping("/create")
    public String createRevenue(@ModelAttribute Revenue revenue) {
        revenueService.saveRevenue(revenue);
        return "redirect:/revenue";
    }
}
