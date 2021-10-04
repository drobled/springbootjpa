package com.example.springboot.JPAMysql.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Riesgo {

    public static final int ALTO =3;
    public static final int BAJO =2;
    public static final int NORMAL =1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional=false)
    private TarjetaCredito tarjetaCredito;

    private Date fecha;
    private int puntuacion;

    @Override
    public String toString() {
        return "Riesgo{" +
                "id=" + id +
                ", tarjetaCredito=" + tarjetaCredito +
                '}';
    }
}
