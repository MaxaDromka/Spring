package com.Security_Agency.demo.Controllers;

import com.Security_Agency.demo.Client;
import com.Security_Agency.demo.Repo.ClientRep;
import com.Security_Agency.demo.Repo.ContractsRepo;
import com.Security_Agency.demo.Service.ClientSrvice;
import com.Security_Agency.demo.Service.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private ClientSrvice clientSrvice;

    @Autowired
    private ClientRep clientRep;
    @Autowired
    private ContractsRepo contractsRepo;

    @GetMapping
    public String getAllCustomers(Model model) {
        Iterable<Client> clientsList = clientSrvice.getAllClient();
        model.addAttribute("clients", clientsList);
        return "clients"; // Убедитесь, что у вас есть шаблон clients.html
    }

    @GetMapping("/new")
    public String createClientForm(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("contracts",contractsRepo.findAll());
        return "client_form"; // Шаблон для создания клиента
    }

    @PostMapping("/create")
    public String createClient(@ModelAttribute Client client) {
        clientRep.save(client);
        return "redirect:/customers"; // Перенаправление на список клиентов
    }

    @GetMapping("/edit/{id}")
    public String editClientForm(@PathVariable Long id, Model model) {
        Client client = clientRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        model.addAttribute("contracts",contractsRepo.findAll());
        return "client_form"; // Шаблон для редактирования клиента
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute Client client) {
        client.setId(id); // Устанавливаем ID для обновления
        clientRep.save(client);
        return "redirect:/customers"; // Перенаправление на список клиентов
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientRep.deleteById(id);
        return "redirect:/customers"; // Перенаправление на список клиентов
    }
}