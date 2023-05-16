package com.example.CrudSpringBoot.RepositoryService;

import com.example.CrudSpringBoot.Entity.Tarjeta;
import com.example.CrudSpringBoot.Entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TarjetaRepositoryService {


    public List<Tarjeta> findAll();

    public Page<Tarjeta> findAll(Pageable pageable);

    public void save (Tarjeta tarjeta);

}
