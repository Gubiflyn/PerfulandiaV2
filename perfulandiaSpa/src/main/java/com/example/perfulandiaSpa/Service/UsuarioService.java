package com.example.perfulandiaSpa.Service;
import com.example.perfulandiaSpa.Model.Usuario;
import com.example.perfulandiaSpa.Repository.UsuarioRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //indica que la clase usuarioService es un servicio
public class UsuarioService {
    @Autowired //inyecto o sincronizar el servicio con el repositorio
    private UsuarioRepository repo;

    //metodo para registrar usuarios a la base de datos
    public Usuario registrar(Usuario u){
        return repo.save(u);//Verificar si el usuario ya existe en la base de datos
    }

    //metodo para autentificar los usuarios
    public Optional<Usuario> autenticar(String email, String password){
        return repo.findByEmail(email).filter(u -> u.getPassword().equals(password)); //filtrar el usuario por email y password
    }

}
