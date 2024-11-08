package com.Security_Agency.demo;

import com.Security_Agency.demo.Service.AmenitiesService;
import com.Security_Agency.demo.Service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final EmployeesService employeesService;
    private final AmenitiesService amenitiesService;
    @Autowired
    public MainController(EmployeesService employeesService, AmenitiesService amenitiesService) {
        this.employeesService = employeesService;
        this.amenitiesService = amenitiesService;
    }


    @GetMapping("/employees")
    public String employees(Model model) {
        List<Employees> employeeList = employeesService.getAllEmployees();
        model.addAttribute("employees", employeeList);
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
        List<Amenities> amenitiesList = amenitiesService.getAllAmenities();
        model.addAttribute("services", amenitiesList);
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
