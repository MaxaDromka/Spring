package com.Security_Agency.demo.Service;

import com.Security_Agency.demo.Amenities;
import com.Security_Agency.demo.Client;
import com.Security_Agency.demo.Repo.ClientRep;
import com.Security_Agency.demo.Repo.SerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientSrvice {
    @Autowired
    private ClientRep clientRep;
    public Iterable<Client> getAllClient() {
        return clientRep.findAll();
    }
}
