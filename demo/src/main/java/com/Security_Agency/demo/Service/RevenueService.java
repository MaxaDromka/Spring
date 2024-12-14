package com.Security_Agency.demo.Service;

import com.Security_Agency.demo.Repo.RevenueRepo;
import com.Security_Agency.demo.Revenue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueService {
    @Autowired
    private RevenueRepo revenueRepository;

    public List<Revenue> getAllRevenue() {
        return revenueRepository.findAll();
    }

    public Revenue saveRevenue(Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    public Revenue getRevenueById(Long id) {
        return revenueRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid revenue Id:" + id));
    }

    public void deleteRevenue(Long id) {
        revenueRepository.deleteById(id);
    }


}
