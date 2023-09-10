package com.co.nexos.mercancia.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@Entity
@Table(name = "mercancia")
public class Mercancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "fecha_ingreso", nullable = false, updatable = false)
    private Date fechaIngreso;

    @LastModifiedDate
    private Date fechaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private Usuario usuario ;
}