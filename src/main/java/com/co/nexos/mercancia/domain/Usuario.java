package com.co.nexos.mercancia.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "edad", nullable = false, length = 100)
    private Integer edad;

    @Column(name = "fecha_ingreso", nullable = false, updatable = false)
    private Date fechaIngreso;

}