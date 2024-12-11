package com.Security_Agency.demo.Repo;

import com.Security_Agency.demo.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employees, Long> {
    @Query("SELECT e FROM Employees e WHERE e.full_name LIKE %:full_name% AND e.position LIKE %:position%")
    List<Employees> searchByFullNameAndPosition(@Param("full_name") String fullName, @Param("position") String position);
}
