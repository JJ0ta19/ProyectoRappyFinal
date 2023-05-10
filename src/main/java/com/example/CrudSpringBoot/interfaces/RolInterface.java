package com.example.CrudSpringBoot.interfaces;


import com.example.CrudSpringBoot.modelo.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolInterface extends CrudRepository<Rol,Long> {
}
