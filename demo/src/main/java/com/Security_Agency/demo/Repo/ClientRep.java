package com.Security_Agency.demo.Repo;

import com.Security_Agency.demo.Client;
import com.Security_Agency.demo.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRep extends JpaRepository<Client, Long> {
}
