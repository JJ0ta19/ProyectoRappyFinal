package com.example.CrudSpringBoot.service;

import com.example.CrudSpringBoot.interfaceService.ClienteInterfaceService;
import com.example.CrudSpringBoot.interfaces.ClienteInterface;
import com.example.CrudSpringBoot.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements ClienteInterfaceService {


    @Autowired
    ClienteInterface repository;

    @Override
    public Iterable<Cliente> getAllUsers() {
        return repository.findAll();
    }

}
