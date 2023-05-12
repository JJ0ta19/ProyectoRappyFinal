package com.example.CrudSpringBoot.Controller;

import com.example.CrudSpringBoot.Entity.Usuario;
import com.example.CrudSpringBoot.Paginacion.PageRender;
import com.example.CrudSpringBoot.RepositoryService.UsuarioRepositoryService;
import com.example.CrudSpringBoot.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepositoryService usuarioService;

    @GetMapping("/ver/{id}")
    public String verDetallesDelUsuario(@PathVariable(value = "id") Long id, Map<String,Object> modelo, RedirectAttributes flash){
        Usuario usuario = usuarioService.findOne(id);
        if (usuario == null) {
            flash.addFlashAttribute("error","El usuario no existe en la base de datos");
            return "redirect:/listar";
        }
        modelo.put("usuario",usuario);
        modelo.put("titulo", "Detalles del usuario"+usuario.getNombre());
        return "ver";
    }

    @GetMapping({"/","listar",""})
    public String listarUsuarios(@RequestParam(name = "page",defaultValue = "0") int page, Model model){
        Pageable pageRequest = PageRequest.of(page,5);
        Page<Usuario> usuarios = usuarioService.findAll(pageRequest);
        PageRender<Usuario> pageRender = new PageRender<>("/listar", usuarios);

        model.addAttribute("titulo","Listado de usuarios");
        model.addAttribute("usuarios",usuarios);
        model.addAttribute("page",pageRender);

        return "listar";
    }

    @GetMapping("/form")
    public String mostrarFormularioDeRegistrarUsuario(Map<String,Object> modelo){
        Usuario usuario = new Usuario();
        modelo.put("usuario", usuario);
        modelo.put("titulo","Registro de usuarios");
        return "form";
    }

    @PostMapping("/form")
    public String guardarUsuario(@Valid Usuario usuario, BindingResult result, Model modelo, RedirectAttributes flash, SessionStatus status){
        if (result.hasErrors()) {
            modelo.addAttribute("titulo","Registro de ususario");
            return "form";
        }
        String mensaje = (usuario.getId() != 0) ? "El empleado ha sido editato con exito" : "Empleado registrado con exito";

        usuarioService.save(usuario);
        status.setComplete();
        flash.addFlashAttribute("success", mensaje);
        return "redirect:/listar";
    }

    @GetMapping("/form/{id}")
    public String editarUsuario(@PathVariable(value = "id") long id, Map<String,Object> modelo,RedirectAttributes flash){
        Usuario usuario = null;
        if (id > 0){
            usuario = usuarioService.findOne(id);
            if (usuario == null) {
                flash.addFlashAttribute("error","El ID del usuario no existe en la base de datos");
                return "redirect:/listar";
            }
        }
        else {
            flash.addFlashAttribute("error","El ID del usuario no puede ser cero");
            return "redirect:/listar";
        }
        modelo.put("usuario",usuario);
        modelo.put("titulo","Edición de usuarios");
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable (value = "id") Long id,RedirectAttributes flash){
        if (id > 0) {
            usuarioService.delete(id);
            flash.addFlashAttribute("success","Usuario eliminado con exito");
        }
        return "redirect:/listar";
    }

}
