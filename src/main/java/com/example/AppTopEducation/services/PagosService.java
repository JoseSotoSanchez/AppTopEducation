    package com.example.AppTopEducation.services;
import com.example.AppTopEducation.entities.PagoEntity;
import com.example.AppTopEducation.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

    @Service
public class PagosService {
    private final PagoRepository pagoRepository;

    @Autowired
    public PagosService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<PagoEntity> obtenerPagosPorIdEstudiante(long id){
        List<PagoEntity> allPagos;
        List<PagoEntity> pagosFiltrado = new ArrayList<>();
        allPagos = pagoRepository.findAll();
        for (PagoEntity pago: allPagos)  {
            if(pago.getId_estudiante().getId_estudiante() == id){
                pagosFiltrado.add(pago);
            }
        }
        return pagosFiltrado;
    }

    public void pagarCuotaEstudiante(long id){
        Optional<PagoEntity> cuota = pagoRepository.findById(id);
        if (cuota.isPresent()) {
            PagoEntity pago = cuota.get();
            Date fechaActual = new Date();
            pago.setFecha_pago(fechaActual);
            pagoRepository.save(pago);
        }
    }

}
