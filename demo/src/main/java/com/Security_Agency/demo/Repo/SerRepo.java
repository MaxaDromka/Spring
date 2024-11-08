package com.Security_Agency.demo.Repo;

import com.Security_Agency.demo.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerRepo  extends JpaRepository<Amenities,Long> {
}
