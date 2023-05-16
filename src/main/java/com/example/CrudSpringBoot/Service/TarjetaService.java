package com.example.CrudSpringBoot.Service;

import com.example.CrudSpringBoot.Entity.Tarjeta;
import com.example.CrudSpringBoot.Entity.Usuario;
import com.example.CrudSpringBoot.Repository.TarjetaRepository;
import com.example.CrudSpringBoot.Repository.UsuarioRepository;
import com.example.CrudSpringBoot.RepositoryService.TarjetaRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TarjetaService implements TarjetaRepositoryService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Tarjeta> findAll() {
        return (List<Tarjeta>) tarjetaRepository.findAll();
    }

    @Override
    public Page<Tarjeta> findAll(Pageable pageable) {
        return tarjetaRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Tarjeta tarjeta) {
        tarjetaRepository.save(tarjeta);
    }
}
