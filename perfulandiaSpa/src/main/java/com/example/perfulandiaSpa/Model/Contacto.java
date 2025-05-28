package com.example.perfulandiaSpa.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contacto")
@Data
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String mensaje;

}
