package com.example.AppTopEducation.controllers;
import com.example.AppTopEducation.entities.EstudianteEntity;
import com.example.AppTopEducation.entities.PagoEntity;
import com.example.AppTopEducation.services.EstudianteService;
import com.example.AppTopEducation.services.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class PagosController {
    private final EstudianteService estudianteService;
    private final PagosService pagosService;

    @Autowired
    public PagosController(EstudianteService estudianteService,PagosService pagosService) {
        this.estudianteService = estudianteService;
        this.pagosService = pagosService;
    }

    @GetMapping("/pagosEstudiantes")
    public String mostrarPagosEstudiantes(Model model) {
        List<EstudianteEntity> estudiantes = estudianteService.obtenerEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "listaPagos";
    }


    /*@GetMapping("/pagosEstudiante/{id}")
    public String mostrarDetallePagosEstudiante(@PathVariable Long id, Model model) {
        List<PagoEntity> pagos = pagosService.obtenerPagosPorIdEstudiante(id);
        model.addAttribute("pagos", pagos);
        return "listaPagos";
    }*/

    @GetMapping("/pagosEstudiante/{id}")
    public ResponseEntity<List<PagoEntity>> obtenerPagosPorEstudiante(@PathVariable Long id) {
        List<PagoEntity> pagos = pagosService.obtenerPagosPorIdEstudiante(id);
        return ResponseEntity.ok(pagos);
    }

    @PostMapping("/pagarCuota/{id}")
    public String pagoCuotaEstudiante(@PathVariable Long id) {
        pagosService.pagarCuotaEstudiante(id);
        return "redirect:/pagosEstudiantes";
    }

}
