package com.example.CrudSpringBoot.RepositoryService;

import com.example.CrudSpringBoot.Entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioRepositoryService {

    public List<Usuario> findAll();

    public Page<Usuario> findAll(Pageable pageable);

    public void save (Usuario usuario);

    public Usuario findOne(Long id);

    public void delete(Long id);

}
