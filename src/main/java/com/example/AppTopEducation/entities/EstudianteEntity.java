package com.example.AppTopEducation.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "estudiante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estudiante;
    private String rut;
    private String apellidos;
    private String nombres;
    private Date fecha_nacimiento;
    private String tipo_colegio_procedencia;
    private String nombre_colegio;
    private int anio_egreso;
    @ManyToOne
    private ArancelEntity id_arancel;

    // Getters y setters
}
