package com.example.AppTopEducation.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;
    private int montoPago;
    private int numero_cuota;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = true)
    private Date fecha_pago;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_vencimiento;

    @OneToOne
    @JoinColumn(name = "id_tipo_pago")
    private TipoPagoEntity id_tipo_pago;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private EstudianteEntity id_estudiante;

    // Getters y setters

    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public int getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(int montoPago) {
        this.montoPago = montoPago;
    }

    public int getNumero_cuota() {
        return numero_cuota;
    }

    public void setNumero_cuota(int numero_cuota) {
        this.numero_cuota = numero_cuota;
    }

    public TipoPagoEntity getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(TipoPagoEntity id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public EstudianteEntity getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(EstudianteEntity id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
}
