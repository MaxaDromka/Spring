package com.Security_Agency.demo.Service;

import com.Security_Agency.demo.Client;
import com.Security_Agency.demo.Employees;
import com.Security_Agency.demo.Repo.ClientRep;
import com.Security_Agency.demo.Repo.EmpRepo;
import com.Security_Agency.demo.SecuredObjects;
import com.Security_Agency.demo.Repo.SecuredObjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecuredObjectsService {

    @Autowired
    private SecuredObjectsRepo securedObjectsRepo;

    @Autowired
    private ClientRep clientRep;
    @Autowired
    private EmpRepo empRepo;
    public SecuredObjects createSecuredObject(SecuredObjects securedObject) {
        // Проверка, что clientName не является отсоединённым объектом
        if (securedObject.getClientName() != null && securedObject.getClientName().getId() != null) {
            Client client = clientRep.findById(securedObject.getClientName().getId())
                    .orElseThrow(() -> new RuntimeException("Client not found"));
            securedObject.setClientName(client);
        }

        if (securedObject.getEmployees() != null) {
            Employees employee = empRepo.findById(securedObject.getEmployees().getId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            securedObject.setEmployees(employee);
        }

        return securedObjectsRepo.save(securedObject);
    }

    public Iterable<SecuredObjects> getAllSecuredObjects() {
        return securedObjectsRepo.findAll();
    }

    public Optional<SecuredObjects> getSecuredObjectById(Long id) {
        return securedObjectsRepo.findById(id);
    }

    public SecuredObjects updateSecuredObject(Long id, SecuredObjects securedObjectDetails) {
        Optional<SecuredObjects> existingSecuredObjectOpt = securedObjectsRepo.findById(id);
        if (existingSecuredObjectOpt.isPresent()) {
            SecuredObjects existingSecuredObject = existingSecuredObjectOpt.get();
            existingSecuredObject.setObjectAddress(securedObjectDetails.getObjectAddress());
            //existingSecuredObject.setClientName(securedObjectDetails.getClientName());
            //existingSecuredObject.setServiceType(securedObjectDetails.getServiceType());
            return securedObjectsRepo.save(existingSecuredObject);
        }
        return null;
    }

    public void deleteAllSecuredObjects() {
        securedObjectsRepo.deleteAll();
    }

    public void deleteSecuredObject(Long id) {
        securedObjectsRepo.deleteById(id);
    }
}