package com.institucion.gestion_cursos.controller;

import com.institucion.gestion_cursos.entity.Curso;
import com.institucion.gestion_cursos.entity.Inscripcion;
import com.institucion.gestion_cursos.repository.CursoRepository;
import com.institucion.gestion_cursos.repository.InscripcionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inscripcion")
public class InscripcionController {

    private final CursoRepository cursoRepository;
    private final InscripcionRepository inscripcionRepository;

    public InscripcionController(CursoRepository cursoRepository, InscripcionRepository inscripcionRepository) {
        this.cursoRepository = cursoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    // 1. Mostrar el formulario
    @GetMapping("/{idCurso}")
    public String mostrarFormulario(@PathVariable Long idCurso, Model model) {
        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new IllegalArgumentException("Curso inválido: " + idCurso));

        // Creamos una inscripción vacía pero ya le asignamos el curso seleccionado
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setCurso(curso);

        model.addAttribute("inscripcion", inscripcion);
        model.addAttribute("curso", curso);

        return "formulario-inscripcion"; // Este es el HTML que crearemos en el siguiente paso
    }

    // 2. Procesar el formulario (Guardar en BD)
    @PostMapping("/guardar")
    public String guardarInscripcion(Inscripcion inscripcion) {
        inscripcionRepository.save(inscripcion);
        return "redirect:/"; // Por ahora, al terminar, volvemos al inicio
    }
}