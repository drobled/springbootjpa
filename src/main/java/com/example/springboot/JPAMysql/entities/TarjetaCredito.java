package com.example.springboot.JPAMysql.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tarjeta_credito")
@Getter
@Setter
public class TarjetaCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroTarjeta;
    private Date ultimoPago;

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "id=" + id +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", ultimoPago=" + ultimoPago +
                '}';
    }
}
