package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.SecuredObjects;
import com.Security_Agency.demo.Service.SecuredObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/secured_objects")
public class SecuredObjectsController {

    @Autowired
    private SecuredObjectsService securedObjectsService;

    @GetMapping
    public String getAllSecuredObjects(Model model) {
        Iterable<SecuredObjects> securedObjectsList = securedObjectsService.getAllSecuredObjects();
        model.addAttribute("secured_objects", securedObjectsList);
        return "secured_objects";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute SecuredObjects securedObject) {
        securedObjectsService.createSecuredObject(securedObject);
        return "redirect:/secured_objects";
    }




}