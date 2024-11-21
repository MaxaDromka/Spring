package com.Security_Agency.demo;

import com.Security_Agency.demo.Service.AmenitiesService;
import com.Security_Agency.demo.Service.ContractsService;
import com.Security_Agency.demo.Service.EmployeesService;
import com.Security_Agency.demo.Service.SecuredObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final EmployeesService employeesService;
    private final AmenitiesService amenitiesService;
    private final ContractsService contractsService;

    private final SecuredObjectsService securedObjectsService;
    @Autowired
    public MainController(EmployeesService employeesService, AmenitiesService amenitiesService, ContractsService contractsService, SecuredObjectsService securedObjectsService) {
        this.employeesService = employeesService;
        this.amenitiesService = amenitiesService;
        this.contractsService = contractsService;
        this.securedObjectsService = securedObjectsService;
    }

    @GetMapping("/")
    public String fun() {
        return "index";
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
        List<Contracts> amenitiesList = contractsService.getAllContracts();
        model.addAttribute("contracts", amenitiesList);
        return "contracts";
    }
    @GetMapping("/services")
    public String services(Model model) {
        Iterable<Amenities> amenitiesList = amenitiesService.getAllAmenities();
        model.addAttribute("services", amenitiesList);
        return "services";
    }
    @GetMapping("/customers")
    public String customers(Model model) {
        return "customers";
    }
    @GetMapping("/secured_objects")
    public String secured_objects(Model model) {
        Iterable<SecuredObjects> securedObjectsList = securedObjectsService.getAllSecuredObjects();
        model.addAttribute("secured_objects", securedObjectsList);
        return "secured_objects";
    }
}
