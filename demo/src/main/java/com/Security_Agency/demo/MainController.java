package com.Security_Agency.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/employees")
    public String employees(Model model) {
        return "employees";
    }
    @GetMapping("/revenue")
    public String revenue(Model model) {
        return "revenue";
    }

    @GetMapping("/contracts")
    public String contracts(Model model) {
        return "contracts";
    }
    @GetMapping("/services")
    public String services(Model model) {
        return "services";
    }
    @GetMapping("/customers")
    public String customers(Model model) {
        return "customers";
    }
    @GetMapping("/secured_objects")
    public String secured_objects(Model model) {
        return "secured_objects";
    }
}
