package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Employees;
import com.Security_Agency.demo.Service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @PostMapping("/create")
    public Employees create(@RequestBody Employees employees) {
        return employeesService.createEmployees(employees);
    }

    @GetMapping
    public List<Employees> getAllEmployees() {
        return employeesService.getAllEmployees();
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