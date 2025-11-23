package com.institucion.gestion_cursos;

import com.institucion.gestion_cursos.entity.Curso;
import com.institucion.gestion_cursos.repository.CursoRepository;
import com.institucion.gestion_cursos.repository.InscripcionRepository; // IMPORTANTE
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CursoRepository cursoRepository;
    private final InscripcionRepository inscripcionRepository; // 1. Nueva dependencia

    // 2. Agregamos el repositorio al constructor
    public DataSeeder(CursoRepository cursoRepository, InscripcionRepository inscripcionRepository) {
        this.cursoRepository = cursoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 3. ¡EL ORDEN IMPORTA!
        // Primero borramos las inscripciones (que dependen de los cursos)
        inscripcionRepository.deleteAll();

        // Luego ya podemos borrar los cursos tranquilamente
        cursoRepository.deleteAll();

        // --- AQUI CREAMOS LOS DATOS NUEVOS ---
        Curso cocina = new Curso();
        cocina.setTitulo("Curso de Cocina Internacional");
        cocina.setDescripcion("Aprende técnicas culinarias avanzadas y platillos exóticos.");
        cocina.setFechaInicio(LocalDate.now().plusDays(15));
        cocina.setCupoMaximo(20);
        cocina.setImagenUrl("https://placehold.co/600x400/orange/white?text=Cocina+Internacional");

        Curso contabilidad = new Curso();
        contabilidad.setTitulo("Contabilidad Básica");
        contabilidad.setDescripcion("Domina los balances, estados de resultados y finanzas.");
        contabilidad.setFechaInicio(LocalDate.now().plusDays(10));
        contabilidad.setCupoMaximo(30);
        contabilidad.setImagenUrl("https://placehold.co/600x400/blue/white?text=Contabilidad+Basica");

        Curso mecanica = new Curso();
        mecanica.setTitulo("Mecánica Automotriz");
        mecanica.setDescripcion("Conoce tu vehículo y aprende a realizar reparaciones básicas.");
        mecanica.setFechaInicio(LocalDate.now().plusDays(20));
        mecanica.setCupoMaximo(15);
        mecanica.setImagenUrl("https://placehold.co/600x400/333333/white?text=Mecanica+Automotriz");

        cursoRepository.saveAll(List.of(cocina, contabilidad, mecanica));
        System.out.println("✅ --- DATOS REINICIADOS CORRECTAMENTE ---");
    }
}