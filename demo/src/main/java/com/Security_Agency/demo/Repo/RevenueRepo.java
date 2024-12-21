package com.Security_Agency.demo.Repo;

import com.Security_Agency.demo.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepo extends JpaRepository<Revenue, Long> {

}
