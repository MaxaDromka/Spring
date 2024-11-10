package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Employees;
import com.Security_Agency.demo.Service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @PostMapping("/create")
    public String create(@ModelAttribute Employees employees, @RequestParam("photo") MultipartFile photo) throws IOException {
        employeesService.createEmployees(employees, photo);
        return "redirect:/employees";
    }

    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employees> employeesList = employeesService.getAllEmployees();
        model.addAttribute("employees", employeesList);
        return "employees";
    }


    @GetMapping("/{id}")
    public Optional<Employees> getEmployeesById(@PathVariable Long id) {
        return employeesService.getEmployeesById(id);
    }


    @PutMapping("/{id}")
    public Employees updateEmployees(@PathVariable Long id, @RequestBody Employees empDetails) {
        return employeesService.updateEmp(id, empDetails);
    }


    @DeleteMapping
    public String deleteAllEmployees() {
        employeesService.deleteAllEmp();
        return "All employees have been deleted successfully.";
    }


    @DeleteMapping("/{id}")
    public void deleteEmployees(@PathVariable Long id) {
        employeesService.deleteEmp(id);
    }
}