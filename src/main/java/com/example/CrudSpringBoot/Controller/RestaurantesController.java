package com.example.CrudSpringBoot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantesController {

    @GetMapping({"/index"})
    public String index(){
        return "index";
    }

    @GetMapping({"/Restaurantes"})
    public String restaurantes(){
        return "Restaurantes";
    }

    @GetMapping({"/Restaurante1"})
    public String restaurantes1(){
        return "Restaurante1";
    }

    @GetMapping({"/Restaurante2"})
    public String restaurantes2(){
        return "Restaurante2";
    }

    @GetMapping({"/Restaurante3"})
    public String restaurantes3(){
        return "Restaurante3";
    }

    @GetMapping({"/Restaurante4"})
    public String restaurantes4(){
        return "Restaurante4";
    }

    @GetMapping({"/Restaurante5"})
    public String restaurantes5(){
        return "Restaurante5";
    }





}
