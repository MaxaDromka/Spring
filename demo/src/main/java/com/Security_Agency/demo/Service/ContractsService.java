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
    private ContractsRepo contractsRepository;

    // Создание нового контракта
    public Contracts createContract(Contracts contract) {
        return contractsRepository.save(contract);
    }

    // Получение всех контрактов
    public List<Contracts> getAllContracts() {
        return contractsRepository.findAll();
    }

    // Получение контракта по ID
    public Optional<Contracts> getContractById(Long id) {
        return contractsRepository.findById(id);
    }

    // Обновление контракта
    public Contracts updateContract(Long id, Contracts contractDetails) {
        Optional<Contracts> existingContractOpt = contractsRepository.findById(id);
        if (existingContractOpt.isPresent()) {
            Contracts existingContract = existingContractOpt.get();
            existingContract.setAmount(contractDetails.getAmount());
            existingContract.setContractStartDate(contractDetails.getContractStartDate());
            existingContract.setContractEndDate(contractDetails.getContractEndDate());
            existingContract.setContractSerialNumber(contractDetails.getContractSerialNumber());
            return contractsRepository.save(existingContract);
        }
        return null;
    }

    // Удаление контракта
    public void deleteContract(Long id) {
        contractsRepository.deleteById(id);
    }
}