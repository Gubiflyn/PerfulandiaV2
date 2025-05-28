package com.example.perfulandiaSpa.Service;

import com.example.perfulandiaSpa.Model.Contacto;
import com.example.perfulandiaSpa.Repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Anotación idéntica a UsuarioService
public class ContactoService {
    
    @Autowired 
    private ContactoRepository repo;
    
    // Método para guardar contacto 
    public Contacto guardarMensaje(Contacto contacto) {
        return repo.save(contacto);
    }
}
