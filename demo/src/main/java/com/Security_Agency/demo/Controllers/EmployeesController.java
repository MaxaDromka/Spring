package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Employees;
import com.Security_Agency.demo.Repo.EmpRepo;
import com.Security_Agency.demo.Service.EmployeesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    private final EmpRepo empRepo;

    public EmployeesController(EmployeesService employeesService, EmpRepo empRepo) {
        this.employeesService = employeesService;
        this.empRepo = empRepo;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Employees employees) throws IOException {
        employeesService.createEmployees(employees);
        return "redirect:/api/employees";
    }


    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employees> employeesList = employeesService.getAllEmployees();
        model.addAttribute("employees", employeesList);
        return "employees";
    }


    @DeleteMapping("/{id}")
    public void deleteEmployees(@PathVariable Long id) {
        employeesService.deleteEmp(id);
    }

    @GetMapping("/{id}")
    public String getEmployeeDetails(Model model, @PathVariable("id") Long id) {
        Optional<Employees> employee = employeesService.getEmployeesById(id);
        if (employee.isPresent()) {
            model.addAttribute("employees", employee.get());
            return "detailsEmp";
        }
        return "redirect:/api/employees";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        if (empRepo.existsById(id)) {
            empRepo.deleteById(id);
        }
        return "redirect:/api/employees";
    }


    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) {
        Optional<Employees> employee = empRepo.findById(id);

        if (employee.isPresent()) {
            model.addAttribute("employees", employee.get());
            return "edit_Emp";
        } else {
            return "redirect:/api/employees";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute Employees employeeDetails) {
        Employees updatedEmployee = employeesService.updateEmp(id, employeeDetails);
        return "redirect:/api/employees";
    }

    @GetMapping("/search")
    public String searchEmployees(
            @RequestParam(required = false, defaultValue = "") String fullName,
            @RequestParam(required = false, defaultValue = "") String position,
            Model model) {
        List<Employees> result = employeesService.searchEmployees(fullName, position);
        model.addAttribute("employees", result);
        return "employees";
    }



}