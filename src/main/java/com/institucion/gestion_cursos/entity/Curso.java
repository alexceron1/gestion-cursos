package com.institucion.gestion_cursos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity // 1. Le dice a Spring: "Esto es una tabla en la base de datos"
@Data   // 2. Lombok: Nos crea Getters, Setters y toString automágicamente
@Table(name = "cursos") // 3. Nombre real de la tabla en Postgres
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementable (1, 2, 3...)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(columnDefinition = "TEXT") // Para descripciones largas
    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;

    private Integer cupoMaximo;

    private String imagenUrl; // Guardaremos la URL de la imagen, no la imagen en sí

    // No necesitas escribir getters ni setters, ¡Lombok lo hace por ti!
}