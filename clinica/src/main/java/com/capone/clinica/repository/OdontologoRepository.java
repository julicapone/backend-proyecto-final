package com.capone.clinica.repository;

import com.capone.clinica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
    @Query("from Odontologo s where s.apellido like %:apellido%")
    List<Odontologo> traerPorApellido(@Param("apellido")String apellido);
}
