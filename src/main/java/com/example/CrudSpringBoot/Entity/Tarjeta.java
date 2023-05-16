package com.example.CrudSpringBoot.Entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "tarjetas")
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private int numero_tarjeta;

    @NotEmpty
    private String fecha_vencimiento;

    @NotNull
    private int codigo_seguridad;

    @NotEmpty
    private String direccion;

    @NotEmpty
    private String ciudad;

    public Tarjeta() {
        super();
    }
}
