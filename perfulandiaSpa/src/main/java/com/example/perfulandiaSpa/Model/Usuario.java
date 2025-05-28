package com.example.perfulandiaSpa.Model;

import java.util.Optional;

import jakarta.persistence.*;
import lombok.Data;

@Entity //indicar que la clase usuario se considere un objeto JPA
@Data //genera los getters y los setters -- generar los metodos getter y setter para ser utilizados en los import de los otros archivos

public class Usuario {
    @Id //indica que este campo es una clave primaria
    @GeneratedValue(strategy = GenerationType .IDENTITY) //genera una id automatica
    private Long id;

    private String nombre;
    private String email;
    private String password;


    //Metodo para crear usuario automaticamente en la base de datos
    public static Optional<Usuario> map(Object o){
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

}
