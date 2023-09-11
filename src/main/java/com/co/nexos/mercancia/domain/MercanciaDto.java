package com.co.nexos.mercancia.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MercanciaDto {
    private String nombre;

    private Integer cantidad;

    private Date fechaIngreso;

    private Usuario usuario;

    public MercanciaDto(String nombre, Integer cantidad, Date fechaIngreso, Usuario usuario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.usuario = usuario;
    }
}
