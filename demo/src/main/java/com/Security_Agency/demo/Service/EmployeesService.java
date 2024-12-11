package com.Security_Agency.demo.Service;

import com.Security_Agency.demo.Repo.EmpRepo;
import com.Security_Agency.demo.Employees;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    private EmpRepo empRepo;

    public Employees createEmployees(Employees employees) throws IOException {
        return empRepo.save(employees);
    }

    public List<Employees> getAllEmployees(){
        return empRepo.findAll();
    }

    public Optional<Employees> getEmployeesById(Long id){
        return  empRepo.findById(id);
    }

    public Employees updateEmp(Long id, Employees empDetails) {
        Optional<Employees> employees = empRepo.findById(id);
        if (employees.isPresent()) {
            Employees existingEmp = employees.get();
            existingEmp.setFull_name(empDetails.getFull_name());
            existingEmp.setPosition(empDetails.getPosition());
            existingEmp.setHire_date(empDetails.getHire_date());
            existingEmp.setSalary(empDetails.getSalary());
            existingEmp.setEducation(empDetails.getEducation());
            return empRepo.save(existingEmp);
        }
        return null;
    }

    public void deleteAllEmp() {
        empRepo.deleteAll();
    }

    public void deleteEmp(Long id) {
        empRepo.deleteById(id);
    }

    public List<Employees> searchEmployees(String fullName, String position) {
        return empRepo.searchByFullNameAndPosition(fullName, position);
    }

}
