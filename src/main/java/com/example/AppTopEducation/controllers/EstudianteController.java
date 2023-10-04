package com.example.AppTopEducation.controllers;
import com.example.AppTopEducation.entities.EstudianteEntity;
import com.example.AppTopEducation.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
