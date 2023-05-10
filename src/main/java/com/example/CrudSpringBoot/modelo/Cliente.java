package com.example.CrudSpringBoot.modelo;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String correo;
    private  String contraseña;
    private  String nombre;
    private  String apellido;
    private  String usuario;
    private  String ciudad;

    @Transient
    private String confirmPassword;

    //Porque Set y no Rol, obligamos a que los datos no se repitan
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "rol_id"))

    private Set<Rol> Roles;


    public Cliente(){}

    public Cliente(int id, String correo, String contraseña,String nombre,String apellido
            ,String usuario,String ciudad, String confirmPassword) {

        this.id = id;
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.ciudad = ciudad;
        this.confirmPassword = confirmPassword;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Set<Rol> getRoles() {
        return Roles;
    }

    public void setRoles(Set<Rol> roles) {
        Roles = roles;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", Roles=" + Roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && Objects.equals(correo, cliente.correo) && Objects.equals(contraseña, cliente.contraseña) && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(usuario, cliente.usuario) && Objects.equals(ciudad, cliente.ciudad) && Objects.equals(confirmPassword, cliente.confirmPassword) && Objects.equals(Roles, cliente.Roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, correo, contraseña, nombre, apellido, usuario, ciudad, confirmPassword, Roles);
    }
}
