package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Amenities;
import com.Security_Agency.demo.Repo.SerRepo;
import com.Security_Agency.demo.SecuredObjects;
import com.Security_Agency.demo.Service.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/services")
public class AmenitiesController {

        @Autowired
        private AmenitiesService amenitiesService;
        @Autowired
        private SerRepo serRepo;

        @PostMapping("/create")
        public String create(@ModelAttribute Amenities amenity) {
                System.out.println("Adding new amenity: " + amenity);
                amenitiesService.createAmenity(amenity);
                return "redirect:/services";
        }

        @GetMapping("/services")
        public String services(Model model) {
                model.addAttribute("services", serRepo.findAll());
                return "services";
        }


        @GetMapping("/{id}")
        public Optional<Amenities> getAmenityById(@PathVariable Long id) {
                return amenitiesService.getAmenityById(id);
        }



        @DeleteMapping
        public String deleteAllAmenities() {
                amenitiesService.deleteAllAmenities();
                return "All amenities have been deleted successfully.";
        }

        @GetMapping("/services/delete/{id}")
        public String deleteAmenity(Model model,@PathVariable("id") Long id) {
                amenitiesService.deleteAmenity(id);
                return "redirect:/services";
        }

        /*@DeleteMapping("/{id}")
        public void deleteAmenity(@PathVariable Long id) {
                amenitiesService.deleteAmenity(id);
        }*/

       /* @GetMapping("/services/delete/{id}")
        public String showServicesPage(Model model) {
                Iterable<Amenities> services = amenitiesService.getAllAmenities();
                model.addAttribute("services", services);
                return "services"; // Убедитесь, что имя соответствует файлу services.html в папке templates
        }*/

        @GetMapping("/edit/{id}")
        public String editAmenity(@PathVariable Long id, Model model) {
                Optional<Amenities> amenity = amenitiesService.getAmenityById(id);
                if (amenity.isPresent()) {
                        model.addAttribute("service", amenity.get());
                } else {
                        return "redirect:/api/services/services";
                }
                return "edit_amenity";
        }

        @PostMapping("/update/{id}")
        public String updateAmenity(@PathVariable Long id, @ModelAttribute Amenities amenity) {
                amenity.setId(id);
                serRepo.save(amenity);
                return "redirect:/api/services/services";
        }

}