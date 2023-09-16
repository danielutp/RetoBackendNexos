package com.co.nexos.mercancia.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cargo")
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = User.class,
            cascade = CascadeType.ALL,
            mappedBy = "charge"
    )
    @JsonManagedReference
    private List<User> users = new ArrayList<>();

}