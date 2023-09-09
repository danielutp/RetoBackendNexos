package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.domain.Mercancia;
import com.co.nexos.mercancia.domain.MercanciaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercanciaService implements IMercanciaService{

    @Override
    public List<Mercancia> listaMercancias() {
        return null;
    }

    @Override
    public Mercancia findByIdMercancia(Integer id) {
        return null;
    }

    @Override
    public Mercancia crearMercancia(MercanciaDto mercanciaDto) {
        return null;
    }

    @Override
    public String actualizarMercancia(Integer id, Integer idUser, Mercancia mercancia) {
        return null;
    }

    @Override
    public String eliminarMercancia(Integer id) {
        return null;
    }
}
