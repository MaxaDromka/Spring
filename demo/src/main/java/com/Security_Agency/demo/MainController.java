package com.Security_Agency.demo;

import com.Security_Agency.demo.Repo.SecuredObjectsRepo;
import com.Security_Agency.demo.Service.*;
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
    private final ClientSrvice clientSrvice;
    private final RevenueService revenueService;

    @Autowired
    private final SecuredObjectsRepo securedObjectsRepo;

    private final SecuredObjectsService securedObjectsService;
    @Autowired
    public MainController(EmployeesService employeesService, AmenitiesService amenitiesService, ContractsService contractsService, ClientSrvice clientSrvice, RevenueService revenueService, SecuredObjectsRepo securedObjectsRepo, SecuredObjectsService securedObjectsService) {
        this.employeesService = employeesService;
        this.amenitiesService = amenitiesService;
        this.contractsService = contractsService;
        this.clientSrvice = clientSrvice;
        this.revenueService = revenueService;
        this.securedObjectsRepo = securedObjectsRepo;
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
        List<Revenue> revenues = revenueService.getAllRevenue();
        List<Contracts> amenitiesList = contractsService.getAllContracts();
        model.addAttribute("contracts", amenitiesList);
        model.addAttribute("revenue",revenues);
        return "revenue";
    }

    @GetMapping("/contracts")
    public String contracts(Model model) {
        List<Contracts> contracts = contractsService.getAllContracts();
        List<Amenities> amenities = amenitiesService.getAllAmenities();
        model.addAttribute("contracts", contracts);
        model.addAttribute("services", amenities);
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
        Iterable<Client> clients = clientSrvice.getAllClient();

        model.addAttribute("clients",clients );

        return "customers";
    }
    @GetMapping("/secured_objects")
    public String secured_objects(Model model) {

        Iterable<SecuredObjects> securedObjectsList = securedObjectsRepo.findAll();
        //Iterable<Amenities> amenities = amenitiesService.getAllAmenities();
        Iterable<Client> clients = clientSrvice.getAllClient();
        Iterable<Employees> employees = employeesService.getAllEmployees();

        model.addAttribute("secured_objects", securedObjectsList);
        // model.addAttribute("services",amenities );
        model.addAttribute("clients",clients );
        model.addAttribute("employees",employees );
        return "secured_objects";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Return the login view
    }

}
