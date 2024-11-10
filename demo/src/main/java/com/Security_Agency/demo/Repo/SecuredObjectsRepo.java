package com.Security_Agency.demo.Repo;

import com.Security_Agency.demo.SecuredObjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecuredObjectsRepo extends JpaRepository<SecuredObjects, Long> {
}