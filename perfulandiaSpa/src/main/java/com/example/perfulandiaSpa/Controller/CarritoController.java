package com.example.perfulandiaSpa.Controller;

import com.example.perfulandiaSpa.Model.Perfume;
import com.example.perfulandiaSpa.Service.PerfumeService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/carrito")
public class CarritoController {
    private final List<Perfume> carrito = new ArrayList<>();
    @Autowired
    private PerfumeService perfumeserv;

    //Metodo para agregar un perfume a carro de compras
    @PostMapping("/agregar/{id}")
    public String agregarPerfume(@PathVariable int id) {
        Perfume perfume = perfumeserv.getPerfumeId(id);
        if (perfume != null && perfumeserv.reducirStock(id)) {
            carrito.add(perfume);
            return "Perfume agregado al carrito " + perfume.getNombre();
        }
        return "Perfume no fue encontrado";
    }

    //Metodo para ver los items del carrito
    @GetMapping
    public List<Perfume> verCarrito(){
        return carrito;
    }

    //Metodo para eliminar items del carrito
    @DeleteMapping("/eliminar/{id}")
    public String eliminarPerfume(@PathVariable int id) {
        boolean eliminado = carrito.removeIf(perfume -> perfume.getId() == id);
        return eliminado ? "Perfume eliminado del carrito" : "Perfume no estaba en el carrito";
    }

    //Metodo para vaciar el carrito
    @DeleteMapping("/vaciar")
    public String vaciarCarrito() {
        carrito.clear();
        return "Carrito vaciado";
    }

    //Metodo para contar los perfumes en el carrito
    @GetMapping("/total")
    public int totalCarrito() {
        return carrito.size();
    }

    @PostMapping
    public String finalizarCompra(){
        for (Perfume perfume : carrito) {
            boolean exito = perfumeserv.reducirStock(perfume.getId());
            if(!exito){
                return "No hay suficiente stock del perfue" + perfume.getNombre();
            }
        }
        carrito.clear();
        return "Compra finalizada con exito";
    }


}
