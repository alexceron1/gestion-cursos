package com.institucion.gestion_cursos.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "inscripciones")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreAspirante;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefono;

    private LocalDateTime fechaInscripcion = LocalDateTime.now();

    // RELACIÓN: Muchas inscripciones pertenecen a un solo Curso
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
}