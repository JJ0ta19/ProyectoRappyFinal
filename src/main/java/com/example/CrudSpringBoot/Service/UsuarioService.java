package com.example.CrudSpringBoot.Service;

import com.example.CrudSpringBoot.Entity.Usuario;
import com.example.CrudSpringBoot.Repository.UsuarioRepository;
import com.example.CrudSpringBoot.RepositoryService.UsuarioRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioService implements UsuarioRepositoryService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Metodo GET
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    //Metodo GET
    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    //Metodo POST
    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    // METODO GET
    @Override
    @Transactional(readOnly = true)
    public Usuario findOne(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // METODO DELETE
    @Override
    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }



}
