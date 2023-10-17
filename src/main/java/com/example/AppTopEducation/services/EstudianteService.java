package com.example.AppTopEducation.services;
import com.example.AppTopEducation.entities.ArancelEntity;
import com.example.AppTopEducation.entities.EstudianteEntity;
import com.example.AppTopEducation.repositories.ArancelRepository;
import com.example.AppTopEducation.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final ArancelRepository arancelRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository, ArancelRepository arancelRepository) {
        this.estudianteRepository = estudianteRepository;
        this.arancelRepository = arancelRepository;
    }

    public EstudianteEntity guardarEstudiante(EstudianteEntity estudiante) {
        estudiante.setMonto_matricula(70000);
        return estudianteRepository.save(estudiante);
    }

    public List<EstudianteEntity> obtenerEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Optional<EstudianteEntity> obtenerEstudiantePorId(Long id){
        return estudianteRepository.findById(id);
    }

    public boolean agregarCuota(long idEstudiante, String tipoColegio,int anioEgreso, int numeroCuotas){
        ArancelEntity arancel = new ArancelEntity();
        int arancelEstudiante = 1500000;
        int descuentoTotalArancel = 0;
        if(tipoColegio.toLowerCase().equals("privado")) descuentoTotalArancel = descuentoTotalArancel + 0;
        if(tipoColegio.toLowerCase().equals("subvencionado")) descuentoTotalArancel = descuentoTotalArancel + (arancelEstudiante - (int)(arancelEstudiante * 0.90));
        if(tipoColegio.toLowerCase().equals("municipal")) descuentoTotalArancel = descuentoTotalArancel + (arancelEstudiante - (int)(arancelEstudiante * 0.80));
        int aniosTranscurridos = LocalDate.now().getYear() - anioEgreso;
        if(aniosTranscurridos < 1) descuentoTotalArancel = descuentoTotalArancel + (arancelEstudiante - (int)(arancelEstudiante * 0.85));
        if(aniosTranscurridos == 1 || aniosTranscurridos == 2) descuentoTotalArancel = descuentoTotalArancel + (arancelEstudiante - (int)(arancelEstudiante * 0.92));
        if(aniosTranscurridos == 3 || aniosTranscurridos == 4) descuentoTotalArancel = descuentoTotalArancel + (arancelEstudiante - (int)(arancelEstudiante * 0.96));
        if(aniosTranscurridos >= 5) descuentoTotalArancel = descuentoTotalArancel + 0;
        arancelEstudiante = arancelEstudiante - descuentoTotalArancel;
        arancel.setMonto_total(arancelEstudiante);

        arancel.setNumero_cuotas(numeroCuotas);
        arancelRepository.save(arancel);
        Optional<EstudianteEntity> estudianteOptional = estudianteRepository.findById(idEstudiante);
        EstudianteEntity estudiante = estudianteOptional.orElse(new EstudianteEntity());
        estudiante.setArancel(arancel);
        estudianteRepository.save(estudiante);
        return true;
    }
}
