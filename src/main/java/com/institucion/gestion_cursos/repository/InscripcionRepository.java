package com.institucion.gestion_cursos.repository;

import com.institucion.gestion_cursos.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}