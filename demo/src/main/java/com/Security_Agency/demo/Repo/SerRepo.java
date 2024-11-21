package com.Security_Agency.demo.Repo;

import com.Security_Agency.demo.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerRepo  extends JpaRepository<Amenities,Long> {
}
