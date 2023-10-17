package com.example.AppTopEducation.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "arancel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArancelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_arancel;
    private int monto_total;
    private int numero_cuotas;

    // Getters y setters

    public Long getId_arancel() {
        return id_arancel;
    }

    public void setId_arancel(Long id_arancel) {
        this.id_arancel = id_arancel;
    }

    public int getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(int monto_total) {
        this.monto_total = monto_total;
    }

    public int getNumero_cuotas() {
        return numero_cuotas;
    }

    public void setNumero_cuotas(int numero_cuotas) {
        this.numero_cuotas = numero_cuotas;
    }


    @Override
    public String toString() {
        return "ArancelEntity{" +
                "id_arancel=" + id_arancel +
                ", monto_total=" + monto_total +
                ", numero_cuotas=" + numero_cuotas +
                '}';
    }
}
