package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Amenities;
import com.Security_Agency.demo.Contracts;
import com.Security_Agency.demo.Service.AmenitiesService;
import com.Security_Agency.demo.Service.ClientSrvice;
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
    @Autowired
    private AmenitiesService amenitiesService;


    @GetMapping
    public String getAllContracts(Model model) {
        List<Contracts> contractsList = contractsService.getAllContracts();
        List<Amenities> amenitiesList = amenitiesService.getAllAmenities();
        model.addAttribute("services",amenitiesList);
        model.addAttribute("contracts", contractsList);
        return "contracts";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Contracts contract) {
        contractsService.createContract(contract);
        return "redirect:/contracts";
    }



    @GetMapping("/edit/{id}")
    public String editContractForm(@PathVariable Long id, Model model) {
        Contracts contract = contractsService.getContractById(id).orElseThrow(() -> new IllegalArgumentException("Invalid contract ID:" + id));
        model.addAttribute("contract", contract);
        return "edit-contract";
    }

    @PostMapping("/edit/{id}")
    public String updateContract(@PathVariable Long id, @ModelAttribute Contracts contractDetails) {
        contractsService.updateContract(id, contractDetails);
        return "redirect:/api/contracts";
    }

    @PostMapping("/delete/{id}")
    public String deleteContract(@PathVariable Long id) {
        contractsService.deleteContract(id);
        return "redirect:/api/contracts";
    }




}