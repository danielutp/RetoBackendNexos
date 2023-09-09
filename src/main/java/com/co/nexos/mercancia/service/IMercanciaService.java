package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.domain.Mercancia;
import com.co.nexos.mercancia.domain.MercanciaDto;

import java.util.List;

public interface IMercanciaService {
    public List<Mercancia> listaMercancias();

    public Mercancia findByIdMercancia(Integer id);
    public Mercancia crearMercancia(MercanciaDto mercanciaDto);

    public String actualizarMercancia(Integer id,Integer idUser, Mercancia mercancia);

    public String eliminarMercancia(Integer id);
}
