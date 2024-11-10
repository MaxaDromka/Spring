package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Amenities;
import com.Security_Agency.demo.Service.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class AmenitiesController {

        @Autowired
        private AmenitiesService amenitiesService;

        @PostMapping("/create")
        public Amenities create(@RequestBody Amenities amenity) {
                return amenitiesService.createAmenity(amenity);
        }

        @GetMapping
        public List<Amenities> getAllAmenities() {
                return amenitiesService.getAllAmenities();
        }


        @GetMapping("/{id}")
        public Optional<Amenities> getAmenityById(@PathVariable Long id) {
                return amenitiesService.getAmenityById(id);
        }


        @PutMapping("/{id}")
        public Amenities updateAmenity(@PathVariable Long id, @RequestBody Amenities amenityDetails) {
                return amenitiesService.updateAmenity(id, amenityDetails);
        }


        @DeleteMapping
        public String deleteAllAmenities() {
                amenitiesService.deleteAllAmenities();
                return "All amenities have been deleted successfully.";
        }

        @DeleteMapping("/{id}")
        public void deleteAmenity(@PathVariable Long id) {
                amenitiesService.deleteAmenity(id);
        }
}