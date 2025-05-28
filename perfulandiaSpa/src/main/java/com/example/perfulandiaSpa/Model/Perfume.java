package com.example.perfulandiaSpa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Perfume {
    private int id;
    private String nombre;
    private String marca;
    private int precio;
    private double ml;

    //Este campo es nuevo para ver la cantidad de stock del producto
    private int stock;
    
}
