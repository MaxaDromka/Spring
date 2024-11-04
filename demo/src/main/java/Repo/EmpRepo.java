package Repo;

import com.Security_Agency.demo.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepo extends CrudRepository<Employees,Long> {
}
