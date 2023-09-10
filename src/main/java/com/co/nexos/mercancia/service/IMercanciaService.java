package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.domain.Mercancia;

import java.util.List;

public interface IMercanciaService {
    public List<Mercancia> listaMercancias();

    public Mercancia findByIdMercancia(Integer id);
    public Mercancia crearMercancia(Mercancia mercancia);

    public Mercancia actualizarMercancia(Integer id, Mercancia mercancia);

    public Mercancia eliminarMercancia(Integer id);
}
