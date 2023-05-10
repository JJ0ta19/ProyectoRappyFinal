package com.example.CrudSpringBoot.controler;

import com.example.CrudSpringBoot.interfaces.RolInterface;
import com.example.CrudSpringBoot.modelo.Cliente;
import com.example.CrudSpringBoot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ClienteController {


    @Autowired
    ClienteService clienteService;

    @Autowired
    RolInterface rolInterface;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/userForm")

    public String userForm(Model model){
        model.addAttribute("userForm", new Cliente());
        model.addAttribute("roles", rolInterface.findAll());
        model.addAttribute("clientelist", clienteService.getAllUsers());

        return "user-form/user-view";
    }


}
