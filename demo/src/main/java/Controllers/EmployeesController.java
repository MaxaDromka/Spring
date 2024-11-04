package Controllers;

import Service.EmployeesService;
import com.Security_Agency.demo.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @PostMapping
    public Employees create(@RequestBody Employees employees){
        return employeesService.createUser(employees);
    }

    // Get all users
    @GetMapping
    public List<Employees> getAllEmployees() {
        return employeesService.getAllEmployees();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public Optional<Employees> getEmployeesById(@PathVariable Long id) {
        return employeesService.getEmployeesById(id);
    }

    // Update user by ID
    @PutMapping("/{id}")
    public Employees updateEmployees(@PathVariable Long id, @RequestBody Employees empDetails) {
        return employeesService.updateEmp(id, empDetails);
    }

    // Delete all users
    @DeleteMapping
    public String deleteAllEmployees() {
        employeesService.getAllEmployees();
        return "All users have been deleted successfully.";
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public void deleteEmployees(@PathVariable Long id) {
        employeesService.deleteEmp(id);
    }
    @GetMapping("/test")
    public List<Employees> test() {
        return employeesService.getAllEmployees();
    }
}
