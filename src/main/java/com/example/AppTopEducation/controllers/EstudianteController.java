package com.example.AppTopEducation.controllers;
import com.example.AppTopEducation.entities.EstudianteEntity;
import com.example.AppTopEducation.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class EstudianteController {
    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estudiante", new EstudianteEntity());
        return "formulario";
    }

    @PostMapping("/guardarEstudiante")
    public String guardarEstudiante(EstudianteEntity estudiante) {
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:/formulario";
    }

    @GetMapping("/estudiantes")
    public String mostrarEstudiantes(Model model) {
        List<EstudianteEntity> estudiantes = estudianteService.obtenerEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "listaEstudiantes";
    }

    @GetMapping("/agregarCuota/{idEstudiante}/tipoColegio/{tipoColegio}/anioEgreso/{anioEgreso}/ncuotas/{ncuotas}")
    public String agregarCuota(@PathVariable Long idEstudiante,@PathVariable String tipoColegio,@PathVariable int anioEgreso,@PathVariable int ncuotas) {
        estudianteService.agregarCuota(idEstudiante,tipoColegio,anioEgreso,ncuotas);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiante/{id}")
    public String mostrarDetallesEstudiante(@PathVariable Long id, Model model) {
        Optional<EstudianteEntity> estudiante = estudianteService.obtenerEstudiantePorId(id);
        model.addAttribute("estudiante", estudiante);
        return "listaEstudiantes";
    }
}
