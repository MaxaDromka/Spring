package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Client;
import com.Security_Agency.demo.Repo.ClientRep;
import com.Security_Agency.demo.Repo.ContractsRepo;
import com.Security_Agency.demo.Repo.SecuredObjectsRepo;
import com.Security_Agency.demo.SecuredObjects;
import com.Security_Agency.demo.Service.ClientSrvice;
import com.Security_Agency.demo.Service.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private ClientSrvice clientSrvice;

    @Autowired
    private ClientRep clientRep;
    @Autowired
    private ContractsRepo contractsRepo;
    @Autowired
    private SecuredObjectsRepo securedObjectsRepo;

    @GetMapping
    public String getAllCustomers(Model model) {
        Iterable<Client> clientsList = clientSrvice.getAllClient();
        model.addAttribute("clients", clientsList);
        return "clients";
    }

    @GetMapping("/new")
    public String createClientForm(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("contracts",contractsRepo.findAll());
        return "client_form";
    }

    @PostMapping("/create")
    public String createClient(@ModelAttribute Client client) {
        clientRep.save(client);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String editClientForm(@PathVariable Long id, Model model) {
        Client client = clientRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        model.addAttribute("contracts",contractsRepo.findAll());
        return "client_form";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute Client client) {
        client.setId(id);
        clientRep.save(client);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        List<SecuredObjects> securedObjectsList = securedObjectsRepo.findByClientNameId(id);
        for (SecuredObjects securedObject : securedObjectsList) {
            securedObjectsRepo.delete(securedObject);
        }

        clientRep.deleteById(id);
        return "redirect:/customers";
    }

}