package com.co.nexos.mercancia.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MercanciaDto {
    private String nombre;

    private Integer cantidad;

    private Date fechaIngreso;

    private Usuario usuario;
}
