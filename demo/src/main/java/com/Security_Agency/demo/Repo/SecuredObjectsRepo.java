package com.Security_Agency.demo.Repo;

import com.Security_Agency.demo.SecuredObjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SecuredObjectsRepo extends CrudRepository<SecuredObjects, Long> {
}