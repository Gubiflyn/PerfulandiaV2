package com.example.perfulandiaSpa.Controller;

import com.example.perfulandiaSpa.Model.Contacto;
import com.example.perfulandiaSpa.Service.ContactoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/contactos")
@CrossOrigin
public class ContactoController {

    @Autowired
    private ContactoService service;

    @PostMapping("/enviar")
    public Contacto enviarMensaje(@RequestBody Contacto contacto) {
        return service.guardarMensaje(contacto);
    }

}
