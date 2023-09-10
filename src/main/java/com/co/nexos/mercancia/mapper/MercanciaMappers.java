package com.co.nexos.mercancia.mapper;

import com.co.nexos.mercancia.domain.Mercancia;
import com.co.nexos.mercancia.domain.MercanciaDto;

public class MercanciaMappers {

    public static Mercancia mercanciaDtoConvertirAMercancia(MercanciaDto mercanciaDto) {
        Mercancia mercancia = new Mercancia();
        mercancia.setNombre(mercanciaDto.getNombre());
        mercancia.setCantidad(mercanciaDto.getCantidad());
        mercancia.setFechaIngreso(mercanciaDto.getFechaIngreso());
        mercancia.setFechaActualizacion(null);
        mercancia.setUsuario(mercanciaDto.getUsuario());
        return mercancia;
    }

}
