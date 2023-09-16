package com.co.nexos.mercancia.dtos;

import com.co.nexos.mercancia.domain.User;
import lombok.Data;

import java.util.Date;

@Data
public class MerchandiseDto {
    private String nombre;

    private Integer cantidad;

    private Date fechaIngreso;

    private User user;

    public MerchandiseDto(String nombre, Integer cantidad, Date fechaIngreso, User user) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.user = user;
    }
}
