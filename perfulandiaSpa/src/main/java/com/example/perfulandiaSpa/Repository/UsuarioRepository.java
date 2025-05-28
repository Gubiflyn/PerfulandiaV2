package com.example.perfulandiaSpa.Repository;

import com.example.perfulandiaSpa.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


//interfaz que extiende de jparepository para proporcionar los metodos CRUD
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email); //metodo de busqueda de ususario por email
}





