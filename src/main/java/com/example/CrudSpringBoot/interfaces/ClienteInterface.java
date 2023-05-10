package com.example.CrudSpringBoot.interfaces;

import com.example.CrudSpringBoot.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ClienteInterface extends CrudRepository<Cliente,Long> {

}
