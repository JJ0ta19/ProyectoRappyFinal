package com.example.CrudSpringBoot.interfaceService;

import com.example.CrudSpringBoot.modelo.Cliente;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.CrudSpringBoot"})
public interface ClienteInterfaceService {

    public Iterable<Cliente> getAllUsers();


}
