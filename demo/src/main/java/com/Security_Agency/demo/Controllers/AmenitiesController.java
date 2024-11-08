package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Amenities;
import com.Security_Agency.demo.Service.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services") // Base URL for amenities
public class AmenitiesController {

        @Autowired
        private AmenitiesService amenitiesService;

        @PostMapping("/create") // For Amenities
        public Amenities create(@RequestBody Amenities amenity) {
                return amenitiesService.createAmenity(amenity);
        }

        // Get all amenities
        @GetMapping
        public List<Amenities> getAllAmenities() {
                return amenitiesService.getAllAmenities();
        }

        // Get amenity by ID
        @GetMapping("/{id}")
        public Optional<Amenities> getAmenityById(@PathVariable Long id) {
                return amenitiesService.getAmenityById(id);
        }

        // Update amenity by ID
        @PutMapping("/{id}")
        public Amenities updateAmenity(@PathVariable Long id, @RequestBody Amenities amenityDetails) {
                return amenitiesService.updateAmenity(id, amenityDetails);
        }

        // Delete all amenities
        @DeleteMapping
        public String deleteAllAmenities() {
                amenitiesService.deleteAllAmenities();
                return "All amenities have been deleted successfully.";
        }

        // Delete amenity by ID
        @DeleteMapping("/{id}")
        public void deleteAmenity(@PathVariable Long id) {
                amenitiesService.deleteAmenity(id);
        }
}