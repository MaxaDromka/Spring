package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Contracts;
import com.Security_Agency.demo.Service.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/contracts")
public class ContractsController {

    @Autowired
    private ContractsService contractsService;

    @GetMapping
    public String getAllContracts(Model model) {
        List<Contracts> contractsList = contractsService.getAllContracts();
        model.addAttribute("contracts", contractsList);
        return "contracts"; // Thymeleaf template name
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Contracts contract) {
        contractsService.createContract(contract);
        return "redirect:/contracts"; // Redirect to the list after creation
    }
}