package com.Security_Agency.demo.Service;

import com.Security_Agency.demo.Amenities;
import com.Security_Agency.demo.Repo.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class AmenitiesService {

    @Autowired
    private SerRepo serRepo;
    @Autowired
    private SecuredObjectsRepo securedObjectsRepo;
    @Autowired
    private ContractsRepo contractsRepo;
    @Autowired
    private RevenueRepo revenueRepo;

    @Autowired
    private ClientRep clientRep;




    public Amenities createAmenity(Amenities amenity) {
        return serRepo.save(amenity);
    }


    public List<Amenities> getAllAmenities() {
        return serRepo.findAll();
    }


    public Optional<Amenities> getAmenityById(Long id) {
        return serRepo.findById(id);
    }


    public Amenities updateAmenity(Long id, Amenities amenityDetails) {
        Optional<Amenities> amenity = serRepo.findById(id);
        if (amenity.isPresent()) {
            Amenities existingAmenity = amenity.get();
            existingAmenity.setServiceName(amenityDetails.getServiceName());
            existingAmenity.setServiceDescription(amenityDetails.getServiceDescription());
            existingAmenity.setServicePrice(amenityDetails.getServicePrice());
            return serRepo.save(existingAmenity);
        }
        return null;
    }


    public void deleteAllAmenities() {
        serRepo.deleteAll();
    }


    public void deleteAmenity(Long id) {
        serRepo.deleteById(id);
    }

    public Amenities getAmenitiesById(Long id) {
        return serRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Service not found for ID: " + id));
    }

    @Transactional
    public void deleteService(Long serviceId) {
        // Обновляем все записи в SecuredObjects, где ссылаются на услугу
        //securedObjectsRepo.updateSecuredObjectsServiceToNull(serviceId);

        // Теперь можно безопасно удалить услугу
        //securedObjectsRepo.deleteById(serviceId);
    }





}