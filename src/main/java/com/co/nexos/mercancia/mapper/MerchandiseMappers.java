package com.co.nexos.mercancia.mapper;

import com.co.nexos.mercancia.domain.Merchandise;
import com.co.nexos.mercancia.dtos.MerchandiseDto;

public class MerchandiseMappers {

    public Merchandise mercanciaDtoConvertirAMercancia(MerchandiseDto merchandiseDto) {
        Merchandise merchandise = new Merchandise();
        merchandise.setNombre(merchandiseDto.getNombre());
        merchandise.setCantidad(merchandiseDto.getCantidad());
        merchandise.setFechaIngreso(merchandiseDto.getFechaIngreso());
        merchandise.setFechaActualizacion(null);
        merchandise.setUser(merchandiseDto.getUser());
        return merchandise;
    }

}
