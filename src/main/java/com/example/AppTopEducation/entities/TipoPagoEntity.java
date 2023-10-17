package com.example.AppTopEducation.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoPagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_pago;
    private String detalle;

    // Getters y setters

    public Long getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(Long id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
