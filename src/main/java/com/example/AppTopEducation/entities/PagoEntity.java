package com.example.AppTopEducation.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int fecha_pago;

    @ManyToOne
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

    public int getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(int fecha_pago) {
        this.fecha_pago = fecha_pago;
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
}
