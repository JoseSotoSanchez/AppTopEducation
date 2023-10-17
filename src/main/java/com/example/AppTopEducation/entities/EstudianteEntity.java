package com.example.AppTopEducation.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_nacimiento;
    private String tipo_colegio_procedencia;
    private String nombre_colegio;
    private int anio_egreso;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_arancel")
    private ArancelEntity arancel;
    private int monto_matricula;

    // Getters y setters


    public Long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTipo_colegio_procedencia() {
        return tipo_colegio_procedencia;
    }

    public void setTipo_colegio_procedencia(String tipo_colegio_procedencia) {
        this.tipo_colegio_procedencia = tipo_colegio_procedencia;
    }

    public String getNombre_colegio() {
        return nombre_colegio;
    }

    public void setNombre_colegio(String nombre_colegio) {
        this.nombre_colegio = nombre_colegio;
    }

    public int getAnio_egreso() {
        return anio_egreso;
    }

    public void setAnio_egreso(int anio_egreso) {
        this.anio_egreso = anio_egreso;
    }

    public ArancelEntity getArancel() {
        return arancel;
    }

    public void setArancel(ArancelEntity arancel) {
        this.arancel = arancel;
    }

    public int getMonto_matricula() {
        return monto_matricula;
    }

    public void setMonto_matricula(int monto_matricula) {
        this.monto_matricula = monto_matricula;
    }

    @Override
    public String toString() {
        return "EstudianteEntity{" +
                "id_estudiante=" + id_estudiante +
                ", rut='" + rut + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombres='" + nombres + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", tipo_colegio_procedencia='" + tipo_colegio_procedencia + '\'' +
                ", nombre_colegio='" + nombre_colegio + '\'' +
                ", anio_egreso=" + anio_egreso +
                ", arancel=" + arancel +
                ", monto_matricula=" + monto_matricula +
                '}';
    }
}
