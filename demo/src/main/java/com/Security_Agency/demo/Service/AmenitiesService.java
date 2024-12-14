package com.Security_Agency.demo.Service;

import com.Security_Agency.demo.Amenities;
import com.Security_Agency.demo.Repo.SerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class AmenitiesService {

    @Autowired
    private SerRepo serRepo;


    public Amenities createAmenity(Amenities amenity) {
        return serRepo.save(amenity);
    }


    public Iterable<Amenities> getAllAmenities() {
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


}