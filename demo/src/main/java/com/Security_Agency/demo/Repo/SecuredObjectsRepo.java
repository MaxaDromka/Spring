package com.Security_Agency.demo.Repo;

import com.Security_Agency.demo.Client;
import com.Security_Agency.demo.SecuredObjects;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecuredObjectsRepo extends CrudRepository<SecuredObjects, Long> {
    //List<SecuredObjects> findByClientNameId(Long clientId);

   // void deleteByClientId(Long clientId);

    List<SecuredObjects> findByClientName(Client client); // Используйте объект Client
    List<SecuredObjects> findByClientNameId(Long clientId); // Или используйте ID клиента

    /*@Modifying
    @Transactional
    @Query("UPDATE SecuredObjects s SET s.serviceType = NULL WHERE s.serviceType.id = :serviceId")
    void updateSecuredObjectsServiceToNull(Long serviceId);

    @Modifying
    @Transactional
    @Query("UPDATE SecuredObjects s SET s.clientName = NULL WHERE s.clientName.id = :clientId")
    void updateSecuredObjectsClientToNull(Long clientId);*/

}