package com.institucion.gestion_cursos.repository;

import com.institucion.gestion_cursos.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // ¡Listo! Al extender de JpaRepository, ya tienes todos los métodos CRUD básicos.
    // No hace falta escribir nada más por ahora.
}