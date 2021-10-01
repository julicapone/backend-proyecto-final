package com.capone.clinica.repository;

import com.capone.clinica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("from Usuario u where u.nombre = :nombre")
    Optional<Usuario> traerUsuarioPorNombre(@Param("nombre") String nombre);
}
