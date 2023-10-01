package com.example.AppTopEducation.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    @JoinColumn(name = "id_arancel")
    private ArancelEntity id_arancel;

    // Getters y setters
}
