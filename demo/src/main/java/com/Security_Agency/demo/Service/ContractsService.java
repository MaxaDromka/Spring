package com.Security_Agency.demo.Service;

import com.Security_Agency.demo.Contracts;
import com.Security_Agency.demo.Repo.ContractsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractsService {

    @Autowired
    private ContractsRepo contractsRepo;

    public Contracts createContract(Contracts contract) {
        return contractsRepo.save(contract);
    }

    public List<Contracts> getAllContracts() {
        return contractsRepo.findAll();
    }

    public Optional<Contracts> getContractById(Long id) {
        return contractsRepo.findById(id);
    }

    public Contracts updateContract(Long id, Contracts contractDetails) {
        Optional<Contracts> existingContractOpt = contractsRepo.findById(id);
        if (existingContractOpt.isPresent()) {
            Contracts existingContract = existingContractOpt.get();
            existingContract.setAmount(contractDetails.getAmount());
            existingContract.setContractStartDate(contractDetails.getContractStartDate());
            existingContract.setContractEndDate(contractDetails.getContractEndDate());
            existingContract.setContractSerialNumber(contractDetails.getContractSerialNumber());
            return contractsRepo.save(existingContract);
        }
        return null;
    }

    public void deleteAllContracts() {
        contractsRepo.deleteAll();
    }

    public void deleteContract(Long id) {
        contractsRepo.deleteById(id);
    }
}