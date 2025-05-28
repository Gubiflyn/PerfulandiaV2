package com.example.perfulandiaSpa.Controller;

import com.example.perfulandiaSpa.Model.Usuario;
import com.example.perfulandiaSpa.Service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.HashMap; //importar la clase HashMap para rear un mapa del objeto
import java.util.Map; //importar la clase Map para manejar los pares clave:valor




@RestController
@RequestMapping("/api/v2/usuarios") //URL BASE PARA LAS DEFINICIONES HTTP
@CrossOrigin //PERMITIR EDICIONES DESDE CUALQUIER ORIGEN 
public class UsuarioController {
    @Autowired
    private UsuarioService serv;

    //metodo para agregar usuarios a la base de datos
    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario u) {
        return serv.registrar(u); //llamar a la funcion registrar del service 
    }
    
    //metodo para autenticar los usuarios logeados
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Usuario u) {
        Optional<Usuario> user = serv.autenticar(u.getEmail(), u.getPassword()); //autenticando al usuario con el email y password
        Map<String, String> respuesta = new HashMap<>(); //crea un nuevo mapa para almacenar las respuestas de la funcion autenticar
        if (user.isPresent()) {
            respuesta.put("result","Ok");
            respuesta.put("nombre", user.get().getNombre());
        } else {
            respuesta.put("result","ERROR");
        }
        return respuesta;
    }
}
