package com.example.AppTopEducation.services;
import com.example.AppTopEducation.entities.EstudianteEntity;
import com.example.AppTopEducation.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public EstudianteEntity guardarEstudiante(EstudianteEntity estudiante) {
        return estudianteRepository.save(estudiante);
    }
}
