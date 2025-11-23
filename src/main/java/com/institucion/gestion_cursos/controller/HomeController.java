/*package com.institucion.gestion_cursos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Esto captura la ruta raíz (localhost:8080)
    public String home() {
        return "home"; // Esto busca un archivo llamado "home.html" en los templates
    }
}*/
package com.institucion.gestion_cursos.controller;

import com.institucion.gestion_cursos.repository.CursoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Importante importar esto
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Inyectamos el repositorio
    private final CursoRepository cursoRepository;

    public HomeController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Buscamos todos los cursos en la BD
        // Y los "pegamos" al modelo con el nombre "misCursos"
        model.addAttribute("misCursos", cursoRepository.findAll());
        return "home";
    }
}