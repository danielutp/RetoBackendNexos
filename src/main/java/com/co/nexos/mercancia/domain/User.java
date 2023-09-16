package com.co.nexos.mercancia.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class User {

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

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = Merchandise.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "user"
    )
    @JsonManagedReference
    private List<Merchandise> merchandises = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Charge.class)
    @JoinColumn(name = "id_cargo", nullable = false)
    @JsonBackReference
    private Charge charge;

}