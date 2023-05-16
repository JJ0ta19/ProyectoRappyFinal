package com.example.CrudSpringBoot.Controller;

import com.example.CrudSpringBoot.Entity.Tarjeta;
import com.example.CrudSpringBoot.Entity.Usuario;
import com.example.CrudSpringBoot.Paginacion.PageRender;
import com.example.CrudSpringBoot.RepositoryService.TarjetaRepositoryService;
import com.example.CrudSpringBoot.RepositoryService.UsuarioRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
@ComponentScan
public class TarjetaController {

    @Autowired
    private TarjetaRepositoryService tarjetaService;

    //Visualizar datos de usuarios base de datos
    @GetMapping({"/listarTarjetas"})
    public String listarTarjetas(@RequestParam(name = "page",defaultValue = "0") int page, Model model){

        Pageable pageRequest = PageRequest.of(page,4);
        Page<Tarjeta> tarjetas = tarjetaService.findAll(pageRequest);
        PageRender<Tarjeta> pageRender = new PageRender<>("/listarTarjetas", tarjetas);

        model.addAttribute("tituloTarjetas","Listado de Tarjetas");
        model.addAttribute("tarjetas",tarjetas);
        model.addAttribute("page",pageRender);

        return "listarTarjetas";
    }



    @GetMapping("/formd")
    public String mostrarFormularioDeRegistrarTarjetas(Map<String,Object> modelo){
        Tarjeta tarjeta = new Tarjeta();
        modelo.put("tarjeta", tarjeta);
        modelo.put("tituloDomicilio","Registro de pago");
        return "domicilio";
    }

    @PostMapping("/formd")
    public String guardarTarjeta(@Valid Tarjeta tarjeta, BindingResult result, Model modelo, RedirectAttributes flash, SessionStatus status){
        if (result.hasErrors()) {
            modelo.addAttribute("tituloDomicilio","Registro de pago");
            return "domicilio";
        }
        tarjetaService.save(tarjeta);

        status.setComplete();
        return "index";
    }



}
