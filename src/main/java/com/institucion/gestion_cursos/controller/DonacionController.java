package com.institucion.gestion_cursos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DonacionController {

    @GetMapping("/donaciones")
    public String mostrarDonaciones() {
        return "donaciones"; // Buscará donaciones.html
    }
}