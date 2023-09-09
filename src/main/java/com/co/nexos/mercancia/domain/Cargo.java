package com.co.nexos.mercancia.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = Usuario.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "cargo"
    )
    @JsonManagedReference
    private List<Usuario> usuarios = new ArrayList<>();

}