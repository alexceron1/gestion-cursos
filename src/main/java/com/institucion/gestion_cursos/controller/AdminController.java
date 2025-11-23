package com.institucion.gestion_cursos.controller;

import com.institucion.gestion_cursos.repository.InscripcionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final InscripcionRepository inscripcionRepository;

    public AdminController(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    @GetMapping
    public String panelAdministrativo(Model model) {
        // Buscamos TODAS las inscripciones de la base de datos
        model.addAttribute("inscripciones", inscripcionRepository.findAll());
        return "admin"; // Buscaremos el archivo admin.html
    }
}