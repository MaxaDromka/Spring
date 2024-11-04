package Repo;

import com.Security_Agency.demo.Employees;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpRepo extends JpaRepository<Employees,Long> {
}
